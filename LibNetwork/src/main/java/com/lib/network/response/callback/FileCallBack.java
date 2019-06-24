package com.lib.network.response.callback;

import com.lib.network.deliver.AndroidDeliver;
import com.lib.network.response.IResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Response;

public abstract class FileCallBack implements IResponse<File> {
    //目标文件存储的文件夹路径
    private String destFileDir;
    // 目标文件存储的文件名
    private String destFileName;

    public FileCallBack(String destFileDir, String destFileName) {
        this.destFileDir = destFileDir;
        this.destFileName = destFileName;
    }


    @Override
    public File parseResult(Response response) throws IOException {
        return saveFile(response);
    }

    public File saveFile(Response response) throws IOException {
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            final long total = response.body().contentLength();

            long sum = 0;

            File dir = new File(destFileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, destFileName);
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                sum += len;
                fos.write(buf, 0, len);
                final long finalSum = sum;
                AndroidDeliver.get().executor(new Runnable() {
                    @Override
                    public void run() {
                        onProgress(finalSum * 1.0f / total, total);
                    }
                });
            }
            fos.flush();
            return file;
        } finally {
            try {
                response.body().close();
                if (is != null) is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
            }

        }
    }

    public abstract void onProgress(float progress, long total);
}

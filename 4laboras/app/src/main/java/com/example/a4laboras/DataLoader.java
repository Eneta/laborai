package com.example.a4laboras;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataLoader extends AsyncTask<String, Void, String> {

    public static String getRate(String code) throws IOException {
        String result = "No Data";
        InputStream stream = download("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
        try {
            result = com.example.a4laboras.Parser.parse(stream, code);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return result;
    }

    private static InputStream download(String urlArg) throws IOException {
        URL url = new URL(urlArg);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(10000);
        connection.setRequestMethod("GET");

        connection.connect();
        return connection.getInputStream();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            return getRate(strings[0]);
        } catch (Exception e) {
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            return writer.toString();
        }
    }
}

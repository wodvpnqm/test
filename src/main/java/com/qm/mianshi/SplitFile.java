package com.qm.mianshi;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by wodvpn on 2017/6/6.
 */
public class SplitFile {
    public final Map<Integer, BufferedWriter> bwMap = new HashMap<Integer, BufferedWriter>();//保存每个文件的流对象
    public final Map<Integer, List<String>>   dataMap   = new HashMap<Integer, List<String>>();//分隔文件用
    /**
     * 大文件分割为小文件
     *
     * @param ipFile
     * @param numberOfFile
     */
    public void splitFile4(File ipFile, int numberOfFile) {
        BufferedReader br = null;
        FileReader fr = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        long startTime = System.currentTimeMillis();
        try {
            fr = new FileReader(ipFile);
            br = new BufferedReader(fr);
            String ipLine = br.readLine();
            //先创建文件及流对象方便使用
            for (int i = 0; i < numberOfFile; i++) {
                File file = new File("e:/tmp/" + i + ".txt");
                bwMap.put(i, new BufferedWriter(new FileWriter(file, true)));
                dataMap.put(i, new LinkedList<String>());
            }
            while (ipLine != null) {
                int hashCode = ipLine.hashCode();
                hashCode = hashCode < 0 ? -hashCode : hashCode;
                int fileNum = hashCode % numberOfFile;
                List<String> list = dataMap.get(fileNum);
                list.add(ipLine + "\n");
                if (list.size() % 1000 == 0) {
                    BufferedWriter writer = bwMap.get(fileNum);
                    for (String line : list) {
                        writer.write(line);
                    }
                    writer.flush();
                    list.clear();
                }
                ipLine = br.readLine();
            }
            for (int fn : bwMap.keySet()) {
                List<String> list = dataMap.get(fn);
                BufferedWriter writer = bwMap.get(fn);
                for (String line : list) {
                    writer.write(line);
                }
                list.clear();
                writer.flush();
                writer.close();
            }
            bwMap.clear();
            long endTime = System.currentTimeMillis();
            System.err.println((endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SplitFile sf = new SplitFile();
        sf.splitFile4(new File("e:/ipAddr.txt"),1000);
    }
}

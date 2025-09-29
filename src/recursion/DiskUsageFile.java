package recursion;

import java.io.File;

public class DiskUsageFile {
    public static void main(String[] args) {
        File root = new File("/Users/lakshmirajaperumalkarthikeyan/Desktop/Important");
        long totalSize = diskUsage(root);
        System.out.println("total size of directory ? " + totalSize);
        String fileNames = diskUsage2(root,"");
        System.out.println("Total files in a dir ? " + fileNames);
    }

    private static String diskUsage2(File root,String fileName) {
        fileName = root.getName()+ " ";
        if(root.isDirectory()){
            for(String childName : root.list()){
                File child = new File(root,childName);
                fileName += diskUsage2(child,fileName);
            }
        }
        return fileName;
    }

    private static long diskUsage(File root) {
        long total = root.length();
        System.out.println(total + "\t" + root);
        if (root.isDirectory()) {
            for (String childName : root.list()) {
                File child = new File(root, childName);
                total += diskUsage(child);
            }
        }
        System.out.println(total + "\t" + root);
        return total;
    }
}

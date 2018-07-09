//package hxyAdmin;
//
//import com.github.tobato.fastdfs.domain.GroupState;
//import com.github.tobato.fastdfs.domain.StorePath;
//import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
//import com.github.tobato.fastdfs.service.FastFileStorageClient;
//import com.github.tobato.fastdfs.service.TrackerClient;
//import com.simple.UserApplication;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.*;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes=UserApplication.class)
//public class FastdfsClientApplicationTests {
//
//    @Autowired
//    private FastFileStorageClient fastFileStorageClient;
//
//    @Autowired
//    private TrackerClient trackerClient;
//
////    @Test
//    public void contextLoads() {
//        List<GroupState> groupStates = trackerClient.listGroups();
//        for (GroupState groupState : groupStates) {
//            System.out.println(groupState);
//        }
//
//    }
//
//    /**
//     * 测试文件上传
//     */
//    @Test
//    public void upload() {
//
//        try {
//            File file = new File("e:\\test.png");
//
//            FileInputStream inputStream = new FileInputStream(file);
//            //StorePath storePath = fastFileStorageClient.uploadFile(inputStream, file.length(), "jpg", null);
//
//            //fastFileStorageClient.uploadSlaveFile(storePath.getGroup(),storePath.getPath(),inputStream,inputStream.available(),"a_",null);
//            fastFileStorageClient.uploadSlaveFile("g1","M00/00/00/wKiAjVlpNjiAK5IHAADGA0F72jo578.jpg",inputStream,inputStream.available(),"a_",null);
//
//            //System.out.println(storePath.getGroup() + " " + storePath.getPath());
//
//            inputStream.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 测试上传缩略图
//     */
////    @Test
//    public void uploadCrtThumbImage() {
//        try {
//            File file = new File("d:\\ds.jpg");
//
//            FileInputStream inputStream = new FileInputStream(file);
//            // 测试上传 缩略图
//            StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(inputStream, file.length(), "jpg", null);
//
//            System.out.println(storePath.getGroup() + "  " + storePath.getPath());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 测试文件下载
//     */
////    @Test
//    public void download() {
//        try {
//            byte[] bytes = fastFileStorageClient.downloadFile("group1", "M00/00/00/wKiAjVlpMfiAagnbAADGA0F72jo134_150x150.jpg", new DownloadByteArray());
//
//            FileOutputStream stream = new FileOutputStream("e:\\a.png");
//
//            stream.write(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//    * 测试文件删除
//     */
////    @Test
//    public void deleteFile(){
//        fastFileStorageClient.deleteFile("group1","M00/00/00/wKiAjVlpQVyARpQwAADGA0F72jo566.jpg");
//    }
//}
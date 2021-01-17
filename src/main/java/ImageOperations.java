import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageOperations {
    public static Mat getImage(String fileName){

        String imagePath = Main.basePath + fileName+Main.imageExt;
        Mat img = Imgcodecs.imread(imagePath);
        if (img.empty()) {
            System.out.println("Не удалось загрузить изображение");
            return null;
        }
        else return  img;
    }
}

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.imgcodecs.Imgcodecs;

public class GaussanNoise {

    public void addNoise(String fileName, String destFileName){

        //Загрузка изображений для обработки
       String imagePath = Main.basePath + fileName+Main.imageExt;
       String destImagePath = Main.basePath + destFileName;
        Mat src = Imgcodecs.imread(imagePath);
        System.out.println("Изображение загружено");

        //Создание матрицы на основе изображения
        Mat dst = new Mat(src.rows(), src.cols(), src.type());

        //Вывод матрицы
        System.out.println("Исходная матрица изображения: ");
//        System.out.println(dst.dump());

        //Создание матрицы для добавления шума
        Mat noise = new Mat(src.rows(), src.cols(), src.type());

        //Расчет математического ожидания и среднеквадратичесого отклонения
        MatOfDouble mean = new MatOfDouble();
        MatOfDouble dev = new MatOfDouble();
        Core.meanStdDev(src,mean,dev);

        //Заполнение матрицы для создания шума
        Core.randn(noise, mean.get(0,0)[0], dev.get(0,0)[0]);

        //Добавление полученного шума в исходну. матрицу изображения
        Core.add(src, noise, dst);

        //Запись полученного изображения в файл
        Imgcodecs.imwrite(destImagePath+Main.imageExt,dst);
    }
}

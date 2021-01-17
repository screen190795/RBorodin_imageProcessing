import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class SmoothingLab {

    public void blur(String fileName, String destFileName) {

        //Указание пути вывода результатов
        String destImagePath = Main.basePath + destFileName;

        //Создание матрицы на основе изображения
        Mat srcImage = ImageOperations.getImage(fileName);

        //Вывод матрицы
        System.out.println("Исходная матрица изображения: \n");
//        System.out.println(srcImage.dump());

        //Применение функции сглаживания
        Mat resultImg1 = new Mat();
        Imgproc.blur(srcImage, resultImg1, new Size(3, 3));

        Mat resultImg2 = new Mat();
        Imgproc.blur(srcImage, resultImg2, new Size(10, 10), new Point(-1, -1));


        //Запись результатов в файл
        Imgcodecs.imwrite(destImagePath + "1" + Main.imageExt, resultImg1);
        Imgcodecs.imwrite(destImagePath + "2" + Main.imageExt, resultImg2);


        //Значения элементов матрицы ядра, при использовании метода blur()
        Mat kernel = Mat.ones(new Size(3, 3), CvType.CV_32FC1);
        Core.divide(kernel, new Scalar(kernel.rows() * kernel.cols()),
                kernel);

        System.out.println("Значения элементов матрицы ядра, при использовании метода blur():\n");
        System.out.println(kernel.dump() + "\n");


    }

    public void gaussian(String fileName, String destFileName) {

        //Создание матрицы на основе изображения
        Mat img = ImageOperations.getImage(fileName);

        //Указание пути вывода результатов
        String destImagePath = Main.basePath + destFileName;

        //Применение функции сглаживания
        Mat resultImg1 = new Mat();
        Imgproc.GaussianBlur(img, resultImg1, new Size(3, 3), 0);
        Mat resultImg2 = new Mat();
        Imgproc.GaussianBlur(img, resultImg2, new Size(45, 45), 0);
        Mat resultImg3 = new Mat();
        Imgproc.GaussianBlur(img, resultImg3, new Size(0, 0), 1.5);


        //Запись результатов в файл
        Imgcodecs.imwrite(destImagePath + "1" + Main.imageExt, resultImg1);
        Imgcodecs.imwrite(destImagePath + "2" + Main.imageExt, resultImg2);

        //Коэффициенты, используемые фильтром Гаусса
        Mat kernel = Imgproc.getGaussianKernel(3, 1.5, CvType.CV_64F);
        System.out.println("Коэффициенты, используемые фильтром Гаусса():\n");
        System.out.println(kernel.dump() + "\n");
    }

    public void bilateral(String fileName, String destFileName) {

        String destImagePath = Main.basePath + destFileName;

        //Создание матрицы на основе изображения
        Mat img = ImageOperations.getImage(fileName);

        Mat resultImg1 = new Mat();
        Imgproc.bilateralFilter(img, resultImg1, 5, 5 * 2, 5 * 2);
        Mat resultImg2 = new Mat();
        Imgproc.bilateralFilter(img, resultImg2, 9, 9 * 2, 9 * 2);

        //Запись результатов в файл
        Imgcodecs.imwrite(destImagePath + "1" + Main.imageExt, resultImg1);
        Imgcodecs.imwrite(destImagePath + "2" + Main.imageExt, resultImg2);

    }

    public void median(String fileName, String destFileName) {

        String destImagePath = Main.basePath + destFileName;

        //Создание матрицы на основе изображения
        Mat img = ImageOperations.getImage(fileName);

        Mat resultImg1 = new Mat();
        Imgproc.medianBlur(img, resultImg1, 3);
        Mat resultImg2 = new Mat();
        Imgproc.medianBlur(img, resultImg2, 5);
        Mat resultImg3 = new Mat();
        Imgproc.medianBlur(img, resultImg3, 45);

        //Запись результатов в файл
        Imgcodecs.imwrite(destImagePath + "1" + Main.imageExt, resultImg1);
        Imgcodecs.imwrite(destImagePath + "2" + Main.imageExt, resultImg2);
        Imgcodecs.imwrite(destImagePath + "3" + Main.imageExt, resultImg2);
    }
}

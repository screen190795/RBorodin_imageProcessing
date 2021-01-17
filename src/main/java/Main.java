import org.opencv.core.Core;

public class Main {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    static final String basePath = "src/main/resources/";
    static final String imageExt = ".png";

    public static void main(String[] args) {
        //Путь к исходному и результирующим изображениям
        String src = "img";
        String noiseDest = "noiseDest";
        String blurDest = "blurDest";
        String gaussianDest = "GaussianDest";
        String bilateralDest = "BilateralDest";
        String medianDest = "MedianDest";


        //Добавление гауссового шума
        GaussanNoise gaussanNoise = new GaussanNoise();
        gaussanNoise.addNoise(src,noiseDest);

        SmoothingLab smoothingLab = new SmoothingLab();

        //Метод blur(): однородное сглаживание
        smoothingLab.blur(noiseDest,blurDest);

        // Метод gaussian(): размытие по Гауссу
        smoothingLab.gaussian(noiseDest,gaussianDest);

        //Метод bilateralFilter(): двустороннее сглаживание
        smoothingLab.bilateral(noiseDest,bilateralDest);

        //Метод medianBlue(): медианный фильтр
        smoothingLab.median(noiseDest,medianDest);
    }




}

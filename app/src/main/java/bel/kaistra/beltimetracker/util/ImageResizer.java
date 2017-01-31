package bel.kaistra.beltimetracker.util;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageResizer {

    public static Bitmap decodeBitmapFromResourse(Resources resources, int resId, int reqWidth, int reqHeight) {
        //этот блок декодирует изображение без выделения памяти, чтобы узнать его настоящие размеры

        final BitmapFactory.Options options = new BitmapFactory.Options();//создаем объект для параметров декодирования
        options.inJustDecodeBounds = true; //назначаем параметр inJustDecodeBounds = true для того, чтобы преждевременно не выделялась память
        BitmapFactory.decodeResource(resources, resId, options);

        //вычисляем коэфициент сжатия изображения
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false; //теперь нам надо получить изображение с выделением памяти

        return BitmapFactory.decodeResource(resources, resId, options);//вызов метода декодирования и возварт уменьшеного изображения

    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

        final int height = options.outHeight;//реальная высота изображения
        final int width = options.outWidth; //реальная ширина изображения
        int inSampleSize = 1; //коэффициент сжатия. тк далее при вычислении значение будет возводиться в степень 2и, то инициализируем переменную 1ей

        if (height > reqHeight || width > reqWidth) {
            //уменьшаем исходную длину и ширину сразу в 2 раза
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}

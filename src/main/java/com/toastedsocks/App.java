package com.toastedsocks;

import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.ColourSpace;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.pixel.statistics.HistogramModel;
import org.openimaj.image.processing.convolution.FGaussianConvolve;
import org.openimaj.image.processor.PixelProcessor;
import org.openimaj.image.typography.hershey.HersheyFont;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * OpenIMAJ Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws IOException {
    	//Create an image

        int count = 0;

        MBFImage image = ImageUtilities.readMBF(new File("c:\\temp\\color.jpg"));
        int width = image.getWidth();
        int height = image.getHeight();

        int widthSquareWidth= width/8;
        int heightSquaresHeight = height/4;


        int number = 0;
        while (number < 10) {
           number++;

        long start = System.currentTimeMillis();

        // Top Row
        for (int wideCount = 0; wideCount < 8; wideCount++) {
            int startX = wideCount*widthSquareWidth;
            int rectSize = widthSquareWidth * 100;
            MBFImage rectangle = image.extractROI(startX, 0, widthSquareWidth, 100);
            Float[] floats = new Float[3];
            floats[0] = (float) 0;
            floats[1] = (float) 0;
            floats[2] = (float) 0.0;
            for (int i = 0; i < rectangle.getWidth(); i++) {
                for (int i2 = 0; i2 < rectangle.getHeight(); i2++) {
                    floats[0] += rectangle.getPixelNative(i, i2)[0];
                    floats[1] += rectangle.getPixelNative(i, i2)[1];
                    floats[2] += rectangle.getPixelNative(i, i2)[2];
                    count++;
                }
            }
//            DisplayUtilities.display(rectangle);
//            System.out.println(((floats[0] / rectSize) * 255) + " " + ((floats[1] / rectSize) * 255) + " " + ((floats[2] / rectSize) * 255));

        }


       // System.out.println();
        // Bottom Row
        for (int wideCount = 0; wideCount < 8; wideCount++) {
            int startX = wideCount*widthSquareWidth;
            int rectSize = widthSquareWidth * 100;
            int topOfBox = image.getHeight() - 100;
            MBFImage rectangle = image.extractROI(startX, topOfBox, widthSquareWidth, 100);
            Float[] floats = new Float[3];
            floats[0] = (float) 0;
            floats[1] = (float) 0;
            floats[2] = (float) 0.0;
            for (int i = 0; i < rectangle.getWidth(); i++) {
                for (int i2 = 0; i2 < rectangle.getHeight(); i2++) {
                    floats[0] += rectangle.getPixelNative(i, i2)[0];
                    floats[1] += rectangle.getPixelNative(i, i2)[1];
                    floats[2] += rectangle.getPixelNative(i, i2)[2];
                    count++;
                }
            }
//                        DisplayUtilities.display(rectangle);

//            System.out.println(((floats[0] / rectSize) * 255) + " " + ((floats[1] / rectSize) * 255) + " " + ((floats[2] / rectSize) * 255));

        }

     //   System.out.println("Left Edge");
        // left edge
        for (int tallCount = 0; tallCount < 4; tallCount++) {
            int startY = tallCount*heightSquaresHeight;
            int rectSize = heightSquaresHeight* 100;
            int topOfBox = image.getHeight() - 100;
            MBFImage rectangle = image.extractROI(0, startY, 100, heightSquaresHeight);
            Float[] floats = new Float[3];
            floats[0] = (float) 0;
            floats[1] = (float) 0;
            floats[2] = (float) 0.0;
            for (int i = 0; i < rectangle.getWidth(); i++) {
                for (int i2 = 0; i2 < rectangle.getHeight(); i2++) {
                    floats[0] += rectangle.getPixelNative(i, i2)[0];
                    floats[1] += rectangle.getPixelNative(i, i2)[1];
                    floats[2] += rectangle.getPixelNative(i, i2)[2];
                    count++;
                }
            }
//            DisplayUtilities.display(rectangle);

//            System.out.println(((floats[0] / rectSize) * 255) + " " + ((floats[1] / rectSize) * 255) + " " + ((floats[2] / rectSize) * 255));

        }

       // System.out.println("Right Edge");
        // left edge
        for (int tallCount = 0; tallCount < 4; tallCount++) {
            int startY = tallCount*heightSquaresHeight;
            int rectSize = heightSquaresHeight* 100;
            int leftOfBox = image.getWidth() - 100;
            MBFImage rectangle = image.extractROI(leftOfBox, startY, 100, heightSquaresHeight);
            Float[] floats = new Float[3];
            floats[0] = (float) 0;
            floats[1] = (float) 0;
            floats[2] = (float) 0.0;
            for (int i = 0; i < rectangle.getWidth(); i++) {
                for (int i2 = 0; i2 < rectangle.getHeight(); i2++) {
                    floats[0] += rectangle.getPixelNative(i, i2)[0];
                    floats[1] += rectangle.getPixelNative(i, i2)[1];
                    floats[2] += rectangle.getPixelNative(i, i2)[2];
                    count++;
                }
            }
//            DisplayUtilities.display(rectangle);

            //System.out.println(((floats[0] / rectSize) * 255) + " " + ((floats[1] / rectSize) * 255) + " " + ((floats[2] / rectSize) * 255));

        }


        System.out.println(System.currentTimeMillis() - start);
        }
//        HistogramModel model = new HistogramModel(4, 4, 4);
//        model.estimateModel(rectangle);

        //Display the image
    }
}

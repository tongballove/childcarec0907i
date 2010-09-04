package utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Taurus
 */
public class SizeMonition implements Runnable
{
    Component component;
    int favoriteWidth;
    int favoriteHeight;
    int widthGrowth;
    int heightGrowth;
    Dimension screenSize;

    /**
     *
     * @param component
     * @param favoriteWidth
     * @param favoriteHeight
     */
    public SizeMonition(Component component, int favoriteWidth, int favoriteHeight)
    {
        this.component = component;
        this.favoriteWidth = favoriteWidth;
        this.favoriteHeight = favoriteHeight;
        getScreenSize();
    }

    /**
     *
     */
    public void gotoCenter()
    {
        component.setLocation(((int) screenSize.getWidth() - component.getWidth()) / 2, ((int) screenSize.getHeight() - component.getHeight()) / 2-25);
    }

    /**
     *
     */
    public void getScreenSize()
    {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public void run()
    {
        try
        {
            if (favoriteWidth < component.getWidth())
                widthGrowth = -1;
            else
                widthGrowth = 1;
            if (favoriteHeight < component.getHeight())
                heightGrowth = -1;
            else
                heightGrowth = 1;

            int oldWidth = component.getWidth();
            int oldHeigth = component.getHeight();
            int widthRange = Math.abs(favoriteWidth - oldWidth);
            int heightRange = Math.abs(favoriteHeight - oldHeigth);
            int aX = 4 * widthRange;
            int aY = 4 * heightRange;
            double halfTime = 500;
            int delay = 15;
            int speed = 30;
            for (double t = 0; t <= halfTime; t = t + speed)
            {
                double sX = aX * (t / 1000) * (t / 1000) / 2;
                component.setSize(oldWidth + (int) sX * widthGrowth, component.getHeight());
                gotoCenter();
                Thread.sleep(delay);
            }
            double v0X = aX * halfTime / 1000;
            oldWidth = component.getWidth();
            for (double t = 0; t < halfTime; t = t + speed)
            {
                double sX = v0X * t / 1000 - aX * (t / 1000) * (t / 1000) / 2;
                component.setSize(oldWidth + (int) sX * widthGrowth, component.getHeight());
                gotoCenter();
                Thread.sleep(delay);
            }

            for (double t = 0; t <= halfTime; t = t + speed)
            {
                double sY = aY * (t / 1000) * (t / 1000) / 2;
                component.setSize(component.getWidth(), oldHeigth + (int) sY * heightGrowth);
                gotoCenter();
                Thread.sleep(delay);
            }
            double v0Y = aY * halfTime / 1000;
            oldHeigth = component.getHeight();
            for (double t = 0; t < halfTime; t = t + speed)
            {
                double sY = v0Y * t / 1000 - aY * (t / 1000) * (t / 1000) / 2;
                component.setSize(component.getWidth(), oldHeigth + (int) sY * heightGrowth);
                gotoCenter();
                Thread.sleep(delay);
            }
            component.setSize(favoriteWidth, favoriteHeight);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

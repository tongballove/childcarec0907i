/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Component;

import Images.ImageHelper;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */

    public class CloseableTabComponent extends JPanel {
        private static ImageIcon closerImage = ImageHelper.loadImage("closer.gif");
        private static ImageIcon closerRolloverImage = ImageHelper.loadImage("closer_rollover.gif");
        private static ImageIcon closerPressedImage = ImageHelper.loadImage("closer_pressed.gif");
        private JLabel titleLabel = null;
        private JButton closeButton = null;
        private JTabbedPane tabbedPane = null;

        public CloseableTabComponent(JTabbedPane aTabbedPane, String name) {
            super(new BorderLayout());
            tabbedPane = aTabbedPane;

            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(1, 0, 0, 0));

            titleLabel = new JLabel(name + "  ");
            titleLabel.setOpaque(false);

            closeButton = new JButton(closerImage);
            closeButton.setRolloverIcon(closerRolloverImage);
            closeButton.setPressedIcon(closerPressedImage);
            closeButton.setBorderPainted(false);
            closeButton.setBorder(BorderFactory.createEmptyBorder());
            closeButton.setFocusPainted(false);
            closeButton.setRolloverEnabled(true);
            closeButton.setOpaque(false);
            closeButton.setContentAreaFilled(false);
            closeButton.setPreferredSize(new Dimension(closerImage.getIconWidth(), closerImage.getIconHeight()));
            closeButton.setSize(new Dimension(closerImage.getIconWidth(), closerImage.getIconHeight()));
            closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                        if (CloseableTabComponent.this.equals(tabbedPane.getTabComponentAt(i))) {
                            tabbedPane.removeTabAt(i);
                            break;
                        }
                    }
                }
            });

            add(titleLabel, BorderLayout.CENTER);
            add(closeButton, BorderLayout.EAST);
        }
    }

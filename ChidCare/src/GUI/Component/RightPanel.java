/*
 * Copyright 2005 MH-Software-Entwicklung. All rights reserved.
 * Use is subject to license terms.
 */
package GUI.Component;

import GUI.frmActivitiesList;
import GUI.frmChildList;
import GUI.frmNannyList;
import java.awt.*;
import javax.swing.*;
import GUI.frmAddOrEditChild;
import GUI.frmAddOrEditNannies;
import GUI.frmAddOrEditUser;
import GUI.frmAgeGroupList;
import GUI.frmClassList;
import GUI.frmUserList;

/**
 *
 * @author Michael Hagen
 */
public class RightPanel extends JPanel {

    private Component parent = null;
    private JTabbedPane tabbedPane = null;

    public RightPanel(Component aParent) {
        super(new BorderLayout());
        parent = aParent;
        init();
    }

    private void init() {

        JPanel bigButtonPanel = new JPanel(new BorderLayout());
        bigButtonPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        JButton bigButton = new JButton("Extra Large");
        bigButtonPanel.add(bigButton, BorderLayout.CENTER);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);


        int tabCount = tabbedPane.getTabCount();
        tabbedPane.add("Start Page", new JPanel());
        tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, "Start Page"));
        tabbedPane.setToolTipTextAt(tabCount, "This is tab No. " + (tabCount + 1));

        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        tabbedPane.setSelectedIndex(0);

        add(tabbedPane, BorderLayout.CENTER);
    }

    public void addSubPane(String title, RightPanel rightpanel, JFrame parent) {
        int tabCount = tabbedPane.getTabCount();


        if (title.equals("Child List")) {
            tabbedPane.add("Child List", new frmChildList(rightpanel));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Child List!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        } else if (title.equals("Nanny List")) {
            tabbedPane.add("Nanny List", new frmNannyList(rightpanel));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Nanny List!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        } else if (title.equals("User List")) {
            tabbedPane.add("User List", new frmUserList(rightpanel));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab User List!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }else if (title.equals("Class List")) {
            tabbedPane.add("Class List", new frmClassList(parent));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Class List!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }else if (title.equals("AgeGroup List")) {
            tabbedPane.add("AgeGroup List", new frmAgeGroupList(parent));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Age Group List!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }else if (title.equals("Activite List")) {
            tabbedPane.add("Activite List", new frmActivitiesList(parent));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Activities List!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }
    }

    public void RemoveTabAt(int i) {
        tabbedPane.removeTabAt(i);
    }

    public void addSubPane(String title, int Code) {

        int tabCount = tabbedPane.getTabCount();

        if (title.equals("Add Children")) {
            tabbedPane.add(title, new frmAddOrEditChild("Add", this));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Add Children!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }else if (title.equals("Add Nanny")){
            tabbedPane.add(title, new frmAddOrEditNannies("Add", this));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Add Nanny!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }else if (title.equals("Add User")){
            tabbedPane.add(title, new frmAddOrEditUser("Add", this));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Add User!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }else if (title.equals("Edit User")){
            tabbedPane.add(title, new frmAddOrEditUser("Edit", Code, this));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Edit User!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }else if (title.equals("Edit Nanny")){
            tabbedPane.add(title, new frmAddOrEditNannies("Edit", Code, this));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Edit Nanny!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }else if (title.equals("Edit Children")){
            tabbedPane.add(title, new frmAddOrEditChild("Edit", Code, this));
            tabbedPane.setTabComponentAt(tabCount, new CloseableTabComponent(tabbedPane, title));
            tabbedPane.setToolTipTextAt(tabCount, "This is tab Edit Childrent!");
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
        }
    }

    public int getCount() {
        int tabCount = tabbedPane.getTabCount();
        return tabCount;
    }

    public boolean getTabTitle(String title, int At) {
        boolean flag = false;
        if (title.equals(tabbedPane.getTitleAt(At))) {
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(title));
            flag = true;
        }
        return flag;
    }
}

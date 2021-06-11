/*
 * Copyright 2013 JavaANPR contributors
 * Copyright 2006 Ondrej Martinsky
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package diplom.MustonovAlprOriginal.javaanpr.gui.windows;
import org.jdesktop.layout.GroupLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class FrameComponentInit extends JFrame {

    private static final long serialVersionUID = 0L;

    /**
     * Creates new form FrameComponentInit.
     */
    public FrameComponentInit() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = getWidth();
        int height = getHeight();
        setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    private void initComponents() {
        JLabel label = new JLabel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Initializing system logic");
        setAlwaysOnTop(true);
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        setFocusable(false);
        setResizable(false);
        setUndecorated(true);
        label.setFont(new Font("Arial", 0, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText("Starting application, please wait ...");
        label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.LEADING)
                .add(label, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING)
                .add(label, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE));
        pack();
    }
}

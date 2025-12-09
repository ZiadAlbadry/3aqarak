// ===============================================
// ForgotPasswordFrame.java - Password Recovery
// ===============================================
package com.ecotech;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class ForgotPasswordFrame extends JFrame {
    private JTextField recoveryField;
    private JComboBox<String> recoveryMethodCombo;

    public ForgotPasswordFrame() {
        setTitle("Eco-Tech - Forgot Password");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(46, 160, 67),
                        getWidth(), getHeight(), new Color(23, 162, 184)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        // Card
        JPanel cardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(0, 0, 0, 20));
                g2d.fillRoundRect(5, 5, getWidth() - 5, getHeight() - 5, 35, 35);
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth() - 5, getHeight() - 5, 35, 35);
            }
        };
        cardPanel.setLayout(null);
        cardPanel.setOpaque(false);
        cardPanel.setBounds(50, 80, 400, 440);

        int y = 50;

        // Title
        JLabel titleLabel = new JLabel("Forgot Password?", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(45, 55, 72));
        titleLabel.setBounds(0, y, 400, 35);
        cardPanel.add(titleLabel);
        y += 50;

        JLabel subtitleLabel = new JLabel("<html><center>Don't worry! Enter your recovery information<br>and we'll send you a reset link</center></html>");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitleLabel.setForeground(new Color(113, 128, 150));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subtitleLabel.setBounds(50, y, 300, 45);
        cardPanel.add(subtitleLabel);
        y += 70;

        // Recovery Method
        JLabel methodLabel = new JLabel("Recovery Method");
        methodLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        methodLabel.setForeground(new Color(74, 85, 104));
        methodLabel.setBounds(50, y, 300, 20);
        cardPanel.add(methodLabel);
        y += 25;

        String[] methods = {"Email Address", "Phone Number", "Username"};
        recoveryMethodCombo = new JComboBox<>(methods);
        recoveryMethodCombo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        recoveryMethodCombo.setBorder(new LineBorder(new Color(226, 232, 240), 2, true));
        recoveryMethodCombo.setBackground(new Color(247, 250, 252));
        recoveryMethodCombo.setBounds(50, y, 300, 45);
        recoveryMethodCombo.addActionListener(e -> updatePlaceholder());
        cardPanel.add(recoveryMethodCombo);
        y += 60;

        // Recovery Field
        JLabel fieldLabel = new JLabel("Enter Your Email");
        fieldLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        fieldLabel.setForeground(new Color(74, 85, 104));
        fieldLabel.setBounds(50, y, 300, 20);
        cardPanel.add(fieldLabel);
        y += 25;

        recoveryField = new JTextField();
        recoveryField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        recoveryField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(226, 232, 240), 2, true),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        recoveryField.setBackground(new Color(247, 250, 252));
        recoveryField.setBounds(50, y, 300, 45);
        cardPanel.add(recoveryField);
        y += 70;

        // Reset Button
        JButton resetBtn = createStyledButton("Send Reset Link", new Color(46, 160, 67));
        resetBtn.setBounds(50, y, 300, 50);
        resetBtn.addActionListener(e -> handleReset());
        cardPanel.add(resetBtn);
        y += 70;

        // Back to login
        JLabel backLabel = new JLabel("<html><u>← Back to Login</u></html>");
        backLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        backLabel.setForeground(new Color(23, 162, 184));
        backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backLabel.setBounds(50, y, 300, 25);
        backLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginFrame();
            }
        });
        cardPanel.add(backLabel);

        mainPanel.add(cardPanel);
        add(mainPanel);
        setVisible(true);
    }

    private void updatePlaceholder() {
        String selected = (String) recoveryMethodCombo.getSelectedItem();
        if (selected.equals("Email Address")) {
            recoveryField.setText("");
        } else if (selected.equals("Phone Number")) {
            recoveryField.setText("");
        } else {
            recoveryField.setText("");
        }
    }

    private void handleReset() {
        String recovery = recoveryField.getText().trim();
        String method = (String) recoveryMethodCombo.getSelectedItem();

        if (recovery.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter your " + method.toLowerCase(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "<html><div style='text-align: center; padding: 10px;'>" +
                        "<h2 style='color: #2ea043;'>Reset Link Sent!</h2>" +
                        "<p>We've sent a password reset link to your " + method.toLowerCase() + "</p>" +
                        "<p style='margin-top: 10px;'>Please check and follow the instructions.</p>" +
                        "</div></html>",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

        dispose();
        new LoginFrame();
    }

    private JButton createStyledButton(String text, Color color) {
        JButton btn = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getModel().isPressed() ? color.darker().darker() :
                        getModel().isRollover() ? color.brighter() : color);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                g2d.setColor(Color.WHITE);
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                g2d.drawString(getText(), (getWidth() - fm.stringWidth(getText())) / 2,
                        (getHeight() + fm.getAscent() - fm.getDescent()) / 2);
            }
        };
        btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }
}// Empty file - add your code here

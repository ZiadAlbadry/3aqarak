// ===============================================
// DashboardPanel.java - Main Dashboard Content
// ===============================================
package com.ecotech;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

class DashboardPanel extends JPanel {
    public DashboardPanel() {
        setLayout(new BorderLayout(20, 20));
        setBackground(new Color(243, 244, 246));
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // Top summary cards
        JPanel cardsPanel = new JPanel(new GridLayout(1, 4, 20, 0));
        cardsPanel.setOpaque(false);

        cardsPanel.add(createSummaryCard("Total Customers", "1,247", "↑ 12%", new Color(46, 160, 67)));
        cardsPanel.add(createSummaryCard("Active Pickups", "89", "↑ 8%", new Color(23, 162, 184)));
        cardsPanel.add(createSummaryCard("Devices Processed", "3,456", "↑ 23%", new Color(168, 85, 247)));
        cardsPanel.add(createSummaryCard("Revenue (EGP)", "₪245,890", "↑ 15%", new Color(251, 146, 60)));

        add(cardsPanel, BorderLayout.NORTH);

        // Middle: Charts and Tables
        JPanel middlePanel = new JPanel(new GridLayout(1, 2, 20, 0));
        middlePanel.setOpaque(false);

        // Left: Recent Pickups
        JPanel pickupsPanel = createTablePanel("Recent Pickups",
                new String[]{"ID", "Customer", "Date", "Status"},
                new Object[][]{
                        {"#1234", "Ahmed Mohamed", "2024-01-15", "Completed"},
                        {"#1235", "Sara Ali", "2024-01-14", "In Progress"},
                        {"#1236", "Mohamed Hassan", "2024-01-14", "Pending"},
                        {"#1237", "Fatma Ibrahim", "2024-01-13", "Completed"},
                        {"#1238", "Omar Khaled", "2024-01-13", "In Progress"}
                });

        // Right: Recent Transactions
        JPanel transactionsPanel = createTablePanel("Recent Transactions",
                new String[]{"ID", "Type", "Amount", "Date"},
                new Object[][]{
                        {"#T5001", "Sale", "₪5,240", "2024-01-15"},
                        {"#T5002", "Purchase", "₪3,120", "2024-01-14"},
                        {"#T5003", "Recycling", "₪1,890", "2024-01-14"},
                        {"#T5004", "Sale", "₪4,560", "2024-01-13"},
                        {"#T5005", "Purchase", "₪2,340", "2024-01-13"}
                });

        middlePanel.add(pickupsPanel);
        middlePanel.add(transactionsPanel);

        add(middlePanel, BorderLayout.CENTER);
    }

    private JPanel createSummaryCard(String title, String value, String change, Color accentColor) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
        };
        card.setLayout(new BorderLayout(10, 10));
        card.setOpaque(false);
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Top: Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        titleLabel.setForeground(new Color(107, 114, 128));
        card.add(titleLabel, BorderLayout.NORTH);

        // Center: Value
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        valueLabel.setForeground(accentColor);
        card.add(valueLabel, BorderLayout.CENTER);

        // Bottom: Change
        JLabel changeLabel = new JLabel(change + " from last month");
        changeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        changeLabel.setForeground(new Color(34, 197, 94));
        card.add(changeLabel, BorderLayout.SOUTH);

        return card;
    }

    private JPanel createTablePanel(String title, String[] columns, Object[][] data) {
        JPanel panel = new JPanel(new BorderLayout(10, 10)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
        };
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(31, 41, 55));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Table
        JTable table = new JTable(data, columns);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(35);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBackground(new Color(249, 250, 251));
        header.setForeground(new Color(107, 114, 128));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}

// ===============================================
// Placeholder Panels (Customers, Pickups, etc.)
// ===============================================
package com.ecotech;

import javax.swing.*;
        import java.awt.*;

class CustomersPanel extends JPanel {
    public CustomersPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(243, 244, 246));
        JLabel label = new JLabel("Customers Management - Coming Soon", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(new Color(107, 114, 128));
        add(label, BorderLayout.CENTER);
    }
}

class PickupsPanel extends JPanel {
    public PickupsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(243, 244, 246));
        JLabel label = new JLabel("Pickups Management - Coming Soon", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(new Color(107, 114, 128));
        add(label, BorderLayout.CENTER);
    }
}

class DevicesPanel extends JPanel {
    public DevicesPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(243, 244, 246));
        JLabel label = new JLabel("Devices Management - Coming Soon", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(new Color(107, 114, 128));
        add(label, BorderLayout.CENTER);
    }
}

class EmployeesPanel extends JPanel {
    public EmployeesPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(243, 244, 246));
        JLabel label = new JLabel("Employees Management - Coming Soon", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(new Color(107, 114, 128));
        add(label, BorderLayout.CENTER);
    }
}

class TransactionsPanel extends JPanel {
    public TransactionsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(243, 244, 246));
        JLabel label = new JLabel("Transactions Management - Coming Soon", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(new Color(107, 114, 128));
        add(label, BorderLayout.CENTER);
    }
}

class PartnersPanel extends JPanel {
    public PartnersPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(243, 244, 246));
        JLabel label = new JLabel("Partners Management - Coming Soon", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(new Color(107, 114, 128));
        add(label, BorderLayout.CENTER);
    }
}

class SettingsPanel extends JPanel {
    public SettingsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(243, 244, 246));
        JLabel label = new JLabel("Settings - Coming Soon", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(new Color(107, 114, 128));
        add(label, BorderLayout.CENTER);
    }
}

// ===============================================
// SignupFrame.java - Registration Screen
// ===============================================
package com.ecotech;

import javax.swing.*;
        import javax.swing.border.*;
        import java.awt.*;
        import java.awt.event.*;
        import com.toedter.calendar.JDateChooser;

class SignupFrame extends JFrame {
    private JTextField firstNameField, lastNameField, phoneField, emailField;
    private JDateChooser birthDateChooser;
    private JComboBox<String> genderComboBox;
    private JPasswordField passwordField, confirmPasswordField;

    public SignupFrame() {
        setTitle("Eco-Tech - Create New Account");
        setSize(550, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel with gradient
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

        // White card with scroll
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
        cardPanel.setPreferredSize(new Dimension(450, 950));

        int y = 40;

        // Title
        JLabel titleLabel = new JLabel("Create Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(new Color(45, 55, 72));
        titleLabel.setBounds(0, y, 450, 40);
        cardPanel.add(titleLabel);
        y += 50;

        JLabel subtitleLabel = new JLabel("Join Eco-Tech Community", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(113, 128, 150));
        subtitleLabel.setBounds(0, y, 450, 20);
        cardPanel.add(subtitleLabel);
        y += 50;

        // First Name
        y = addFieldWithLabel(cardPanel, "First Name", y);
        firstNameField = createStyledTextField();
        firstNameField.setBounds(50, y, 350, 45);
        cardPanel.add(firstNameField);
        y += 60;

        // Last Name
        y = addFieldWithLabel(cardPanel, "Last Name", y);
        lastNameField = createStyledTextField();
        lastNameField.setBounds(50, y, 350, 45);
        cardPanel.add(lastNameField);
        y += 60;

        // Phone
        y = addFieldWithLabel(cardPanel, "Phone Number", y);
        phoneField = createStyledTextField();
        phoneField.setBounds(50, y, 350, 45);
        cardPanel.add(phoneField);
        y += 60;

        // Email
        y = addFieldWithLabel(cardPanel, "Email Address", y);
        emailField = createStyledTextField();
        emailField.setBounds(50, y, 350, 45);
        cardPanel.add(emailField);
        y += 60;

        // Birth Date
        y = addFieldWithLabel(cardPanel, "Date of Birth", y);
        birthDateChooser = new JDateChooser();
        birthDateChooser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        birthDateChooser.setBorder(new LineBorder(new Color(226, 232, 240), 2, true));
        birthDateChooser.setBackground(new Color(247, 250, 252));
        birthDateChooser.setBounds(50, y, 350, 45);
        cardPanel.add(birthDateChooser);
        y += 60;

        // Gender
        y = addFieldWithLabel(cardPanel, "Gender", y);
        String[] genders = {"Select Gender", "Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genderComboBox.setBorder(new LineBorder(new Color(226, 232, 240), 2, true));
        genderComboBox.setBackground(new Color(247, 250, 252));
        genderComboBox.setBounds(50, y, 350, 45);
        cardPanel.add(genderComboBox);
        y += 60;

        // Password
        y = addFieldWithLabel(cardPanel, "Password", y);
        passwordField = createStyledPasswordField();
        passwordField.setBounds(50, y, 350, 45);
        cardPanel.add(passwordField);
        y += 60;

        // Confirm Password
        y = addFieldWithLabel(cardPanel, "Confirm Password", y);
        confirmPasswordField = createStyledPasswordField();
        confirmPasswordField.setBounds(50, y, 350, 45);
        cardPanel.add(confirmPasswordField);
        y += 70;

        // Sign Up Button
        JButton signupBtn = createStyledButton("Create Account", new Color(46, 160, 67));
        signupBtn.setBounds(50, y, 350, 50);
        signupBtn.addActionListener(e -> handleSignup());
        cardPanel.add(signupBtn);
        y += 70;

        // Back to login
        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        loginPanel.setOpaque(false);
        loginPanel.setBounds(50, y, 350, 30);

        JLabel loginText = new JLabel("Already have an account?");
        loginText.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        loginText.setForeground(new Color(113, 128, 150));
        loginPanel.add(loginText);

        JLabel loginLink = new JLabel("<html><u>Login</u></html>");
        loginLink.setFont(new Font("Segoe UI", Font.BOLD, 13));
        loginLink.setForeground(new Color(46, 160, 67));
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginFrame();
            }
        });
        loginPanel.add(loginLink);
        cardPanel.add(loginPanel);

        // Scroll pane
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBounds(50, 30, 450, 780);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        mainPanel.add(scrollPane);
        add(mainPanel);
        setVisible(true);
    }

    private void handleSignup() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            showError("Please fill all required fields");
            return;
        }

        if (birthDateChooser.getDate() == null) {
            showError("Please select your date of birth");
            return;
        }

        if (genderComboBox.getSelectedIndex() == 0) {
            showError("Please select your gender");
            return;
        }

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            showError("Please enter password");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match");
            return;
        }

        // Success message
        JOptionPane.showMessageDialog(this,
                "<html><div style='text-align: center; padding: 10px;'>" +
                        "<h2 style='color: #2ea043;'>Registration Successful!</h2>" +
                        "<p>Your account has been created successfully.</p>" +
                        "<p>Our team will review your information and activate your account soon.</p>" +
                        "<p style='margin-top: 10px;'><b>You will receive a confirmation email shortly.</b></p>" +
                        "</div></html>",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

        dispose();
        new LoginFrame();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Registration Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private int addFieldWithLabel(JPanel panel, String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label.setForeground(new Color(74, 85, 104));
        label.setBounds(50, y, 350, 20);
        panel.add(label);
        return y + 25;
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(226, 232, 240), 2, true),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        field.setBackground(new Color(247, 250, 252));
        return field;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(226, 232, 240), 2, true),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        field.setBackground(new Color(247, 250, 252));
        return field;
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

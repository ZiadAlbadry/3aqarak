
// ===============================================
// LoginFrame.java - Login Screen
// ===============================================
package com.ecotech;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox rememberMeCheckbox;
    private BufferedImage logoImage;

    public LoginFrame() {
        setTitle("Eco-Tech - Smart E-Waste Management System");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Load logo
        try {
            logoImage = ImageIO.read(new File("eco_tech_logo.png"));
        } catch (Exception e) {
            System.out.println("⚠️ Logo not found: eco_tech_logo.png");
        }

        // Main panel with gradient
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(46, 160, 67),
                        getWidth(), getHeight(), new Color(23, 162, 184)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Decorative circles
                g2d.setColor(new Color(255, 255, 255, 20));
                g2d.fillOval(-50, -50, 200, 200);
                g2d.fillOval(getWidth() - 150, getHeight() - 150, 200, 200);
            }
        };
        mainPanel.setLayout(null);

        // White card
        JPanel cardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Shadow effect
                g2d.setColor(new Color(0, 0, 0, 20));
                g2d.fillRoundRect(5, 5, getWidth() - 5, getHeight() - 5, 35, 35);

                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth() - 5, getHeight() - 5, 35, 35);
            }
        };
        cardPanel.setLayout(null);
        cardPanel.setOpaque(false);
        cardPanel.setBounds(50, 40, 400, 620);

        int y = 40;

        // Logo
        JLabel logoLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (logoImage != null) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    int logoSize = 140;
                    int x = (getWidth() - logoSize) / 2;
                    g2d.drawImage(logoImage, x, 0, logoSize, logoSize, null);
                }
            }
        };
        logoLabel.setBounds(0, y, 400, 140);
        cardPanel.add(logoLabel);
        y += 150;

        // Title
        JLabel titleLabel = new JLabel("Welcome Back!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(45, 55, 72));
        titleLabel.setBounds(0, y, 400, 35);
        cardPanel.add(titleLabel);
        y += 40;

        JLabel subtitleLabel = new JLabel("Smart E-Waste Management", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(113, 128, 150));
        subtitleLabel.setBounds(0, y, 400, 20);
        cardPanel.add(subtitleLabel);
        y += 50;

        // Username
        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        userLabel.setForeground(new Color(74, 85, 104));
        userLabel.setBounds(50, y, 300, 20);
        cardPanel.add(userLabel);
        y += 25;

        usernameField = createStyledTextField("Enter your username");
        usernameField.setBounds(50, y, 300, 45);
        cardPanel.add(usernameField);
        y += 60;

        // Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        passLabel.setForeground(new Color(74, 85, 104));
        passLabel.setBounds(50, y, 300, 20);
        cardPanel.add(passLabel);
        y += 25;

        passwordField = createStyledPasswordField("Enter your password");
        passwordField.setBounds(50, y, 300, 45);
        cardPanel.add(passwordField);
        y += 55;

        // Remember Me & Forgot Password
        rememberMeCheckbox = new JCheckBox("Remember Me");
        rememberMeCheckbox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        rememberMeCheckbox.setForeground(new Color(74, 85, 104));
        rememberMeCheckbox.setOpaque(false);
        rememberMeCheckbox.setFocusPainted(false);
        rememberMeCheckbox.setBounds(50, y, 130, 25);
        cardPanel.add(rememberMeCheckbox);

        JLabel forgotLabel = new JLabel("<html><u>Forgot Password?</u></html>");
        forgotLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        forgotLabel.setForeground(new Color(23, 162, 184));
        forgotLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotLabel.setBounds(210, y, 140, 25);
        forgotLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new ForgotPasswordFrame();
            }
            public void mouseEntered(MouseEvent e) {
                forgotLabel.setForeground(new Color(46, 160, 67));
            }
            public void mouseExited(MouseEvent e) {
                forgotLabel.setForeground(new Color(23, 162, 184));
            }
        });
        cardPanel.add(forgotLabel);
        y += 45;

        // Login Button
        JButton loginBtn = createStyledButton("Login", new Color(46, 160, 67));
        loginBtn.setBounds(50, y, 300, 50);
        loginBtn.addActionListener(e -> handleLogin());
        cardPanel.add(loginBtn);
        y += 70;

        // Divider
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(226, 232, 240));
        separator.setBounds(50, y, 300, 1);
        cardPanel.add(separator);
        y += 20;

        // Sign Up
        JPanel signupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        signupPanel.setOpaque(false);
        signupPanel.setBounds(50, y, 300, 30);

        JLabel signupText = new JLabel("Don't have an account?");
        signupText.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        signupText.setForeground(new Color(113, 128, 150));
        signupPanel.add(signupText);

        JLabel signupLink = new JLabel("<html><u>Sign Up</u></html>");
        signupLink.setFont(new Font("Segoe UI", Font.BOLD, 13));
        signupLink.setForeground(new Color(46, 160, 67));
        signupLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new SignupFrame();
            }
            public void mouseEntered(MouseEvent e) {
                signupLink.setForeground(new Color(23, 162, 184));
            }
            public void mouseExited(MouseEvent e) {
                signupLink.setForeground(new Color(46, 160, 67));
            }
        });
        signupPanel.add(signupLink);
        cardPanel.add(signupPanel);

        // Enter key listener
        KeyAdapter enterListener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) handleLogin();
            }
        };
        usernameField.addKeyListener(enterListener);
        passwordField.addKeyListener(enterListener);

        mainPanel.add(cardPanel);
        add(mainPanel);
        setVisible(true);
    }

    private void handleLogin() {
        String user = usernameField.getText().trim();
        String pass = new String(passwordField.getPassword()).trim();

        if (user.isEmpty() || pass.isEmpty()) {
            showError("Please enter both username and password");
            return;
        }

        // Demo: admin/admin
        if (user.equals("admin") && pass.equals("admin")) {
            dispose();
            new MainDashboard(user);
        } else {
            showError("Invalid username or password");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Login Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private JTextField createStyledTextField(String placeholder) {
        JTextField field = new JTextField(placeholder);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setForeground(Color.GRAY);
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(226, 232, 240), 2, true),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        field.setBackground(new Color(247, 250, 252));

        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
                field.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(46, 160, 67), 2, true),
                        BorderFactory.createEmptyBorder(8, 15, 8, 15)
                ));
                field.setBackground(Color.WHITE);
            }
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
                field.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(226, 232, 240), 2, true),
                        BorderFactory.createEmptyBorder(8, 15, 8, 15)
                ));
                field.setBackground(new Color(247, 250, 252));
            }
        });
        return field;
    }

    private JPasswordField createStyledPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setEchoChar((char) 0);
        field.setText(placeholder);
        field.setForeground(Color.GRAY);
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(226, 232, 240), 2, true),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        field.setBackground(new Color(247, 250, 252));

        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (new String(field.getPassword()).equals(placeholder)) {
                    field.setText("");
                    field.setEchoChar('●');
                    field.setForeground(Color.BLACK);
                }
                field.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(46, 160, 67), 2, true),
                        BorderFactory.createEmptyBorder(8, 15, 8, 15)
                ));
                field.setBackground(Color.WHITE);
            }
            public void focusLost(FocusEvent e) {
                if (new String(field.getPassword()).isEmpty()) {
                    field.setEchoChar((char) 0);
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
                field.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(226, 232, 240), 2, true),
                        BorderFactory.createEmptyBorder(8, 15, 8, 15)
                ));
                field.setBackground(new Color(247, 250, 252));
            }
        });
        return field;
    }

    private JButton createStyledButton(String text, Color color) {
        JButton btn = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (getModel().isPressed()) {
                    g2d.setColor(color.darker().darker());
                } else if (getModel().isRollover()) {
                    g2d.setColor(color.brighter());
                } else {
                    g2d.setColor(color);
                }

                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);

                g2d.setColor(Color.WHITE);
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                int textX = (getWidth() - fm.stringWidth(getText())) / 2;
                int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2d.drawString(getText(), textX, textY);
            }
        };

        btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }
}

// ===============================================
// MainDashboard.java - Main Dashboard with Sidebar
// ===============================================
package com.ecotech;

import javax.swing.*;
        import javax.swing.border.*;
        import java.awt.*;
        import java.awt.event.*;

class MainDashboard extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JLabel pageTitleLabel;
    private String currentUser;
    private JButton activeButton = null;

    public MainDashboard(String username) {
        this.currentUser = username;

        setTitle("Eco-Tech Management System");
        setSize(1400, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Top Navigation Bar
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Sidebar
        JPanel sidebarPanel = createSidebar();
        add(sidebarPanel, BorderLayout.WEST);

        // Content Area with CardLayout
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(new Color(243, 244, 246));

        // Add all panels
        contentPanel.add(new DashboardPanel(), "Dashboard");
        contentPanel.add(new CustomersPanel(), "Customers");
        contentPanel.add(new PickupsPanel(), "Pickups");
        contentPanel.add(new DevicesPanel(), "Devices");
        contentPanel.add(new EmployeesPanel(), "Employees");
        contentPanel.add(new TransactionsPanel(), "Transactions");
        contentPanel.add(new PartnersPanel(), "Partners");
        contentPanel.add(new SettingsPanel(), "Settings");

        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(229, 231, 235)),
                BorderFactory.createEmptyBorder(15, 25, 15, 25)
        ));
        topPanel.setPreferredSize(new Dimension(0, 70));

        // Left: Page Title
        pageTitleLabel = new JLabel("Dashboard");
        pageTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        pageTitleLabel.setForeground(new Color(31, 41, 55));
        topPanel.add(pageTitleLabel, BorderLayout.WEST);

        // Right: User info + Logout
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        rightPanel.setOpaque(false);

        // Notifications
        JButton notifBtn = createIconButton("🔔", new Color(249, 250, 251));
        notifBtn.setToolTipText("Notifications");
        rightPanel.add(notifBtn);

        // User info
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        userPanel.setOpaque(false);

        JLabel userIcon = new JLabel("👤");
        userIcon.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        userPanel.add(userIcon);

        JPanel userTextPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        userTextPanel.setOpaque(false);

        JLabel userName = new JLabel(currentUser);
        userName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        userName.setForeground(new Color(31, 41, 55));
        userTextPanel.add(userName);

        JLabel userRole = new JLabel("Administrator");
        userRole.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        userRole.setForeground(new Color(107, 114, 128));
        userTextPanel.add(userRole);

        userPanel.add(userTextPanel);
        rightPanel.add(userPanel);

        // Logout button
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBackground(new Color(239, 68, 68));
        logoutBtn.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        logoutBtn.setFocusPainted(false);
        logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to logout?", "Confirm Logout",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
                new LoginFrame();
            }
        });
        rightPanel.add(logoutBtn);

        topPanel.add(rightPanel, BorderLayout.EAST);

        return topPanel;
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(14, 23, 38));
        sidebar.setPreferredSize(new Dimension(260, 0));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Logo area
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        logoPanel.setOpaque(false);
        logoPanel.setMaximumSize(new Dimension(260, 80));

        JLabel logoLabel = new JLabel("🌿 Eco-Tech");
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        logoLabel.setForeground(Color.WHITE);
        logoPanel.add(logoLabel);

        sidebar.add(logoPanel);
        sidebar.add(Box.createVerticalStrut(20));

        // Menu buttons
        JButton dashboardBtn = createMenuButton("📊", "Dashboard");
        JButton customersBtn = createMenuButton("👥", "Customers");
        JButton pickupsBtn = createMenuButton("📦", "Pickups");
        JButton devicesBtn = createMenuButton("💻", "Devices");
        JButton employeesBtn = createMenuButton("👨‍💼", "Employees");
        JButton transactionsBtn = createMenuButton("💰", "Transactions");
        JButton partnersBtn = createMenuButton("🤝", "Partners");
        JButton settingsBtn = createMenuButton("⚙️", "Settings");

        sidebar.add(dashboardBtn);
        sidebar.add(customersBtn);
        sidebar.add(pickupsBtn);
        sidebar.add(devicesBtn);
        sidebar.add(employeesBtn);
        sidebar.add(transactionsBtn);
        sidebar.add(partnersBtn);
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(settingsBtn);

        // Set Dashboard as active by default
        setActiveButton(dashboardBtn);

        return sidebar;
    }

    private JButton createMenuButton(String icon, String text) {
        JButton btn = new JButton(icon + "  " + text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btn.setForeground(new Color(156, 163, 175));
        btn.setBackground(new Color(14, 23, 38));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 4, 0, 0, new Color(14, 23, 38)),
                BorderFactory.createEmptyBorder(12, 20, 12, 20)
        ));
        btn.setMaximumSize(new Dimension(260, 50));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (btn != activeButton) {
                    btn.setBackground(new Color(30, 41, 59));
                }
            }
            public void mouseExited(MouseEvent e) {
                if (btn != activeButton) {
                    btn.setBackground(new Color(14, 23, 38));
                }
            }
        });

        btn.addActionListener(e -> {
            setActiveButton(btn);
            cardLayout.show(contentPanel, text);
            pageTitleLabel.setText(text);
        });

        return btn;
    }

    private void setActiveButton(JButton btn) {
        if (activeButton != null) {
            activeButton.setBackground(new Color(14, 23, 38));
            activeButton.setForeground(new Color(156, 163, 175));
            activeButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 4, 0, 0, new Color(14, 23, 38)),
                    BorderFactory.createEmptyBorder(12, 20, 12, 20)
            ));
        }

        activeButton = btn;
        btn.setBackground(new Color(30, 41, 59));
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 4, 0, 0, new Color(46, 160, 67)),
                BorderFactory.createEmptyBorder(12, 20, 12, 20)
        ));
    }

    private JButton createIconButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btn.setBackground(bg);
        btn.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }
}// Empty file - add your code here

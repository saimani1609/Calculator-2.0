package calc;

import javax.swing.JApplet;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class CalculatorApplet extends JApplet {
  private final ButtonGroup buttonGroupView = new ButtonGroup();
  private final ButtonGroup buttonGroupFormat = new ButtonGroup();
  private JPanel panelStandard;
  private JPanel panelScientificNested;
  private JTextArea textAreaOutputFormula;
  private JTextArea textAreaOutput;
  
  private Calculator calculator;
  
  public void init() {
    setSize(475, 250);
    getContentPane().setLayout(new CardLayout(0, 0));
    
    ButtonEventHandler buttonEvents = new ButtonEventHandler();
    KeyBoardEventHandler keyboardEvents = new KeyBoardEventHandler();
    calculator = new Calculator(40);
    
    panelStandard = new JPanel();
    panelStandard.setFocusable(true);
    panelStandard.addKeyListener(keyboardEvents);
    panelStandard.setFocusTraversalKeysEnabled(false);
    getContentPane().add(panelStandard, "name_6009966325892");
    panelStandard.setBackground(Color.WHITE);
    GridBagLayout gbl_panelStandard = new GridBagLayout();
    gbl_panelStandard.columnWidths = new int[] {1, 48, 48, 48, 48, 48};
    gbl_panelStandard.rowHeights = new int[] {5, 32, 32, 32, 32, 32, 32, 0};
    gbl_panelStandard.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    gbl_panelStandard.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    panelStandard.setLayout(gbl_panelStandard);
    
    JPanel panel = new JPanel();
    panel.setFocusable(false);
    panel.setFocusTraversalKeysEnabled(false);
    panel.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel.setBackground(Color.WHITE);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.gridwidth = 6;
    gbc_panel.insets = new Insets(0, 0, 5, 0);
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 0;
    gbc_panel.gridy = 1;
    panelStandard.add(panel, gbc_panel);
    GridBagLayout gbl_panel = new GridBagLayout();
    gbl_panel.columnWidths = new int[]{5, 0, 5};
    gbl_panel.rowHeights = new int[]{0, 0};
    gbl_panel.columnWeights = new double[]{1.0};
    gbl_panel.rowWeights = new double[]{0.0, 0.0};
    panel.setLayout(gbl_panel);
    
    textAreaOutputFormula = new JTextArea("");
    GridBagConstraints gbc_textAreaOutputFormula = new GridBagConstraints();
    gbc_textAreaOutputFormula.anchor = GridBagConstraints.SOUTHEAST;
    gbc_textAreaOutputFormula.insets = new Insets(0, 0, 5, 0);
    gbc_textAreaOutputFormula.gridx = 1;
    gbc_textAreaOutputFormula.gridy = 0;
    panel.add(textAreaOutputFormula, gbc_textAreaOutputFormula);
    textAreaOutputFormula.setFont(new Font("Monospaced", Font.PLAIN, 10));
    textAreaOutputFormula.setFocusable(false);
    textAreaOutputFormula.setEditable(false);
    
    textAreaOutput = new JTextArea("0");
    textAreaOutput.setFocusable(false);
    GridBagConstraints gbc_textAreaOutput = new GridBagConstraints();
    gbc_textAreaOutput.anchor = GridBagConstraints.NORTHEAST;
    gbc_textAreaOutput.gridx = 1;
    gbc_textAreaOutput.gridy = 1;
    panel.add(textAreaOutput, gbc_textAreaOutput);
    textAreaOutput.setFont(new Font("Monospaced", Font.PLAIN, 17));
    textAreaOutput.setEditable(false);
    
    panelScientificNested = new JPanel();
    panelScientificNested.setFocusable(false);
    panelScientificNested.setFocusTraversalKeysEnabled(false);
    panelScientificNested.setBackground(Color.WHITE);
    GridBagConstraints gbc_panelScientificNested = new GridBagConstraints();
    gbc_panelScientificNested.gridheight = 6;
    gbc_panelScientificNested.insets = new Insets(0, 0, 0, 5);
    gbc_panelScientificNested.fill = GridBagConstraints.BOTH;
    gbc_panelScientificNested.gridx = 0;
    gbc_panelScientificNested.gridy = 2;
    panelStandard.add(panelScientificNested, gbc_panelScientificNested);
    GridBagLayout gbl_panelScientificNested = new GridBagLayout();
    gbl_panelScientificNested.columnWidths = new int[] {48, 48, 48, 48};
    gbl_panelScientificNested.rowHeights = new int[] {32, 32, 32, 32, 32, 0};
    gbl_panelScientificNested.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
    gbl_panelScientificNested.rowWeights = new double[]{1.0, 0.0};
    panelScientificNested.setLayout(gbl_panelScientificNested);
    
    JButton buttonBlank2 = new JButton("");
    buttonBlank2.setBackground(Color.WHITE);
    buttonBlank2.setEnabled(false);
    buttonBlank2.setFocusable(false);
    buttonBlank2.setFocusTraversalKeysEnabled(false);
    buttonBlank2.setMargin(new Insets(2, 2, 2, 2));
    buttonBlank2.setActionCommand("");
    GridBagConstraints gbc_buttonBlank2 = new GridBagConstraints();
    gbc_buttonBlank2.fill = GridBagConstraints.BOTH;
    gbc_buttonBlank2.insets = new Insets(0, 0, 5, 5);
    gbc_buttonBlank2.gridx = 0;
    gbc_buttonBlank2.gridy = 0;
    panelScientificNested.add(buttonBlank2, gbc_buttonBlank2);
    
    JButton buttonPi = new JButton("\u03C0");
    buttonPi.setFocusable(false);
    buttonPi.setFocusTraversalKeysEnabled(false);
    buttonPi.setMargin(new Insets(2, 2, 2, 2));
    buttonPi.setActionCommand("pi");
    GridBagConstraints gbc_buttonPi = new GridBagConstraints();
    gbc_buttonPi.fill = GridBagConstraints.BOTH;
    gbc_buttonPi.insets = new Insets(0, 0, 5, 5);
    gbc_buttonPi.gridx = 1;
    gbc_buttonPi.gridy = 0;
    panelScientificNested.add(buttonPi, gbc_buttonPi);
    
    JButton buttonLn = new JButton("ln");
    buttonLn.setFocusable(false);
    buttonLn.setFocusTraversalKeysEnabled(false);
    buttonLn.setMargin(new Insets(2, 2, 2, 2));
    buttonLn.setActionCommand("ln");
    GridBagConstraints gbc_buttonLn = new GridBagConstraints();
    gbc_buttonLn.fill = GridBagConstraints.BOTH;
    gbc_buttonLn.insets = new Insets(0, 0, 5, 5);
    gbc_buttonLn.gridx = 2;
    gbc_buttonLn.gridy = 0;
    panelScientificNested.add(buttonLn, gbc_buttonLn);
    
    JButton buttonExp = new JButton("e\u02E3");
    buttonExp.setFocusable(false);
    buttonExp.setFocusTraversalKeysEnabled(false);
    buttonExp.setMargin(new Insets(2, 2, 2, 2));
    buttonExp.setActionCommand("exp");
    GridBagConstraints gbc_buttonExp = new GridBagConstraints();
    gbc_buttonExp.fill = GridBagConstraints.BOTH;
    gbc_buttonExp.insets = new Insets(0, 0, 5, 5);
    gbc_buttonExp.gridx = 3;
    gbc_buttonExp.gridy = 0;
    panelScientificNested.add(buttonExp, gbc_buttonExp);
    
    JButton buttonAsin = new JButton("sin\u207B\u00B9");
    buttonAsin.setFocusable(false);
    buttonAsin.setFocusTraversalKeysEnabled(false);
    buttonAsin.setMargin(new Insets(2, 2, 2, 2));
    buttonAsin.setActionCommand("asin");
    GridBagConstraints gbc_buttonAsin = new GridBagConstraints();
    gbc_buttonAsin.fill = GridBagConstraints.BOTH;
    gbc_buttonAsin.insets = new Insets(0, 0, 5, 5);
    gbc_buttonAsin.gridx = 0;
    gbc_buttonAsin.gridy = 1;
    panelScientificNested.add(buttonAsin, gbc_buttonAsin);
    
    JButton buttonSin = new JButton("sin");
    buttonSin.setFocusable(false);
    buttonSin.setFocusTraversalKeysEnabled(false);
    buttonSin.setMargin(new Insets(2, 2, 2, 2));
    buttonSin.setActionCommand("sin");
    GridBagConstraints gbc_buttonSin = new GridBagConstraints();
    gbc_buttonSin.fill = GridBagConstraints.BOTH;
    gbc_buttonSin.insets = new Insets(0, 0, 5, 5);
    gbc_buttonSin.gridx = 1;
    gbc_buttonSin.gridy = 1;
    panelScientificNested.add(buttonSin, gbc_buttonSin);
    
    JButton buttonX2 = new JButton("x\u00B2");
    buttonX2.setFocusable(false);
    buttonX2.setFocusTraversalKeysEnabled(false);
    buttonX2.setMargin(new Insets(2, 2, 2, 2));
    buttonX2.setActionCommand("square");
    GridBagConstraints gbc_buttonX2 = new GridBagConstraints();
    gbc_buttonX2.fill = GridBagConstraints.BOTH;
    gbc_buttonX2.insets = new Insets(0, 0, 5, 5);
    gbc_buttonX2.gridx = 2;
    gbc_buttonX2.gridy = 1;
    panelScientificNested.add(buttonX2, gbc_buttonX2);
    
    JButton buttonN = new JButton("n!");
    buttonN.setFocusable(false);
    buttonN.setFocusTraversalKeysEnabled(false);
    buttonN.setMargin(new Insets(2, 2, 2, 2));
    buttonN.setActionCommand("factorial");
    GridBagConstraints gbc_buttonN = new GridBagConstraints();
    gbc_buttonN.fill = GridBagConstraints.BOTH;
    gbc_buttonN.insets = new Insets(0, 0, 5, 5);
    gbc_buttonN.gridx = 3;
    gbc_buttonN.gridy = 1;
    panelScientificNested.add(buttonN, gbc_buttonN);
    
    JButton buttonAcos = new JButton("cos\u207B\u00B9");
    buttonAcos.setFocusable(false);
    buttonAcos.setFocusTraversalKeysEnabled(false);
    buttonAcos.setMargin(new Insets(2, 2, 2, 2));
    buttonAcos.setActionCommand("acos");
    GridBagConstraints gbc_buttonAcos = new GridBagConstraints();
    gbc_buttonAcos.fill = GridBagConstraints.BOTH;
    gbc_buttonAcos.insets = new Insets(0, 0, 5, 5);
    gbc_buttonAcos.gridx = 0;
    gbc_buttonAcos.gridy = 2;
    panelScientificNested.add(buttonAcos, gbc_buttonAcos);
    
    JButton buttonCos = new JButton("cos");
    buttonCos.setFocusable(false);
    buttonCos.setFocusTraversalKeysEnabled(false);
    buttonCos.setMargin(new Insets(2, 2, 2, 2));
    buttonCos.setActionCommand("cos");
    GridBagConstraints gbc_buttonCos = new GridBagConstraints();
    gbc_buttonCos.fill = GridBagConstraints.BOTH;
    gbc_buttonCos.insets = new Insets(0, 0, 5, 5);
    gbc_buttonCos.gridx = 1;
    gbc_buttonCos.gridy = 2;
    panelScientificNested.add(buttonCos, gbc_buttonCos);
    
    JButton buttonXY = new JButton("x\u02B8");
    buttonXY.setFocusable(false);
    buttonXY.setFocusTraversalKeysEnabled(false);
    buttonXY.setMargin(new Insets(2, 2, 2, 2));
    buttonXY.setActionCommand("x2y");
    GridBagConstraints gbc_buttonXY = new GridBagConstraints();
    gbc_buttonXY.fill = GridBagConstraints.BOTH;
    gbc_buttonXY.insets = new Insets(0, 0, 5, 5);
    gbc_buttonXY.gridx = 2;
    gbc_buttonXY.gridy = 2;
    panelScientificNested.add(buttonXY, gbc_buttonXY);
    
    JButton buttonYx = new JButton("\u02B8\u221Ax ");
    buttonYx.setFocusable(false);
    buttonYx.setFocusTraversalKeysEnabled(false);
    buttonYx.setMargin(new Insets(2, 2, 2, 2));
    buttonYx.setActionCommand("yroot");
    GridBagConstraints gbc_buttonYx = new GridBagConstraints();
    gbc_buttonYx.anchor = GridBagConstraints.SOUTH;
    gbc_buttonYx.fill = GridBagConstraints.HORIZONTAL;
    gbc_buttonYx.insets = new Insets(0, 0, 5, 5);
    gbc_buttonYx.gridx = 3;
    gbc_buttonYx.gridy = 2;
    panelScientificNested.add(buttonYx, gbc_buttonYx);
    
    JButton buttonAtan = new JButton("tan\u207B\u00B9");
    buttonAtan.setFocusable(false);
    buttonAtan.setFocusTraversalKeysEnabled(false);
    buttonAtan.setMargin(new Insets(2, 2, 2, 2));
    buttonAtan.setActionCommand("atan");
    GridBagConstraints gbc_buttonAtan = new GridBagConstraints();
    gbc_buttonAtan.fill = GridBagConstraints.BOTH;
    gbc_buttonAtan.insets = new Insets(0, 0, 5, 5);
    gbc_buttonAtan.gridx = 0;
    gbc_buttonAtan.gridy = 3;
    panelScientificNested.add(buttonAtan, gbc_buttonAtan);
    
    JButton buttonTan = new JButton("tan");
    buttonTan.setFocusable(false);
    buttonTan.setFocusTraversalKeysEnabled(false);
    buttonTan.setMargin(new Insets(2, 2, 2, 2));
    buttonTan.setActionCommand("tan");
    GridBagConstraints gbc_buttonTan = new GridBagConstraints();
    gbc_buttonTan.fill = GridBagConstraints.BOTH;
    gbc_buttonTan.insets = new Insets(0, 0, 5, 5);
    gbc_buttonTan.gridx = 1;
    gbc_buttonTan.gridy = 3;
    panelScientificNested.add(buttonTan, gbc_buttonTan);
    
    JButton buttonX3 = new JButton("x\u00B3");
    buttonX3.setFocusable(false);
    buttonX3.setFocusTraversalKeysEnabled(false);
    buttonX3.setMargin(new Insets(2, 2, 2, 2));
    buttonX3.setActionCommand("cube");
    GridBagConstraints gbc_buttonX3 = new GridBagConstraints();
    gbc_buttonX3.fill = GridBagConstraints.BOTH;
    gbc_buttonX3.insets = new Insets(0, 0, 5, 5);
    gbc_buttonX3.gridx = 2;
    gbc_buttonX3.gridy = 3;
    panelScientificNested.add(buttonX3, gbc_buttonX3);
    
    JButton button3x = new JButton("\u221Bx ");
    button3x.setFocusable(false);
    button3x.setFocusTraversalKeysEnabled(false);
    button3x.setMargin(new Insets(2, 2, 2, 2));
    button3x.setActionCommand("cuberoot");
    GridBagConstraints gbc_button3x = new GridBagConstraints();
    gbc_button3x.fill = GridBagConstraints.BOTH;
    gbc_button3x.insets = new Insets(0, 0, 5, 5);
    gbc_button3x.gridx = 3;
    gbc_button3x.gridy = 3;
    panelScientificNested.add(button3x, gbc_button3x);
    
    JButton buttonBlank3 = new JButton("");
    buttonBlank3.setBackground(Color.WHITE);
    buttonBlank3.setEnabled(false);
    buttonBlank3.setFocusable(false);
    buttonBlank3.setFocusTraversalKeysEnabled(false);
    buttonBlank3.setMargin(new Insets(2, 2, 2, 2));
    buttonBlank3.setActionCommand("");
    GridBagConstraints gbc_buttonBlank3 = new GridBagConstraints();
    gbc_buttonBlank3.fill = GridBagConstraints.BOTH;
    gbc_buttonBlank3.insets = new Insets(0, 0, 5, 5);
    gbc_buttonBlank3.gridx = 0;
    gbc_buttonBlank3.gridy = 4;
    panelScientificNested.add(buttonBlank3, gbc_buttonBlank3);
    
    JButton buttonMod = new JButton("Mod");
    buttonMod.setFocusable(false);
    buttonMod.setFocusTraversalKeysEnabled(false);
    buttonMod.setMargin(new Insets(2, 2, 2, 2));
    buttonMod.setActionCommand("mod");
    GridBagConstraints gbc_buttonMod = new GridBagConstraints();
    gbc_buttonMod.fill = GridBagConstraints.BOTH;
    gbc_buttonMod.insets = new Insets(0, 0, 5, 5);
    gbc_buttonMod.gridx = 1;
    gbc_buttonMod.gridy = 4;
    panelScientificNested.add(buttonMod, gbc_buttonMod);
    
    JButton buttonLog = new JButton("log");
    buttonLog.setFocusable(false);
    buttonLog.setFocusTraversalKeysEnabled(false);
    buttonLog.setMargin(new Insets(2, 2, 2, 2));
    buttonLog.setActionCommand("log");
    GridBagConstraints gbc_buttonLog = new GridBagConstraints();
    gbc_buttonLog.fill = GridBagConstraints.BOTH;
    gbc_buttonLog.insets = new Insets(0, 0, 5, 5);
    gbc_buttonLog.gridx = 2;
    gbc_buttonLog.gridy = 4;
    panelScientificNested.add(buttonLog, gbc_buttonLog);
    
    JButton button10x = new JButton("10\u02E3");
    button10x.setFocusable(false);
    button10x.setFocusTraversalKeysEnabled(false);
    button10x.setMargin(new Insets(2, 2, 2, 2));
    button10x.setActionCommand("10x");
    GridBagConstraints gbc_button10x = new GridBagConstraints();
    gbc_button10x.insets = new Insets(0, 0, 5, 5);
    gbc_button10x.fill = GridBagConstraints.BOTH;
    gbc_button10x.gridx = 3;
    gbc_button10x.gridy = 4;
    panelScientificNested.add(button10x, gbc_button10x);
    
    JButton buttonBackspace = new JButton("\u21A9");
    buttonBackspace.setFocusable(false);
    buttonBackspace.setFocusTraversalKeysEnabled(false);
    buttonBackspace.setMargin(new Insets(2, 2, 2, 2));
    buttonBackspace.setActionCommand("backspace");
    GridBagConstraints gbc_buttonBackspace = new GridBagConstraints();
    gbc_buttonBackspace.fill = GridBagConstraints.BOTH;
    gbc_buttonBackspace.insets = new Insets(0, 0, 5, 5);
    gbc_buttonBackspace.gridx = 1;
    gbc_buttonBackspace.gridy = 2;
    panelStandard.add(buttonBackspace, gbc_buttonBackspace);
    
    JButton buttonCE = new JButton("CE");
    buttonCE.setFocusable(false);
    buttonCE.setFocusTraversalKeysEnabled(false);
    buttonCE.setMargin(new Insets(2, 2, 2, 2));
    buttonCE.setActionCommand("ce");
    GridBagConstraints gbc_buttonCE = new GridBagConstraints();
    gbc_buttonCE.fill = GridBagConstraints.BOTH;
    gbc_buttonCE.insets = new Insets(0, 0, 5, 5);
    gbc_buttonCE.gridx = 2;
    gbc_buttonCE.gridy = 2;
    panelStandard.add(buttonCE, gbc_buttonCE);
    
    JButton buttonC = new JButton("C");
    buttonC.setFocusable(false);
    buttonC.setFocusTraversalKeysEnabled(false);
    buttonC.setMargin(new Insets(2, 2, 2, 2));
    buttonC.setActionCommand("c");
    GridBagConstraints gbc_buttonC = new GridBagConstraints();
    gbc_buttonC.fill = GridBagConstraints.BOTH;
    gbc_buttonC.insets = new Insets(0, 0, 5, 5);
    gbc_buttonC.gridx = 3;
    gbc_buttonC.gridy = 2;
    panelStandard.add(buttonC, gbc_buttonC);
    
    JButton buttonNegate = new JButton("\u00B1");
    buttonNegate.setFocusable(false);
    buttonNegate.setFocusTraversalKeysEnabled(false);
    buttonNegate.setMargin(new Insets(2, 2, 2, 2));
    buttonNegate.setActionCommand("negate");
    GridBagConstraints gbc_buttonNegate = new GridBagConstraints();
    gbc_buttonNegate.fill = GridBagConstraints.BOTH;
    gbc_buttonNegate.insets = new Insets(0, 0, 5, 5);
    gbc_buttonNegate.gridx = 4;
    gbc_buttonNegate.gridy = 2;
    panelStandard.add(buttonNegate, gbc_buttonNegate);
    
    JButton buttonSquareRoot = new JButton("\u221A");
    buttonSquareRoot.setFocusable(false);
    buttonSquareRoot.setFocusTraversalKeysEnabled(false);
    buttonSquareRoot.setMargin(new Insets(2, 2, 2, 2));
    buttonSquareRoot.setActionCommand("sqroot");
    GridBagConstraints gbc_buttonSquareRoot = new GridBagConstraints();
    gbc_buttonSquareRoot.fill = GridBagConstraints.BOTH;
    gbc_buttonSquareRoot.insets = new Insets(0, 0, 5, 0);
    gbc_buttonSquareRoot.gridx = 5;
    gbc_buttonSquareRoot.gridy = 2;
    panelStandard.add(buttonSquareRoot, gbc_buttonSquareRoot);
    
    JButton button7 = new JButton("7");
    button7.setFocusable(false);
    button7.setFocusTraversalKeysEnabled(false);
    button7.setMargin(new Insets(2, 2, 2, 2));
    button7.setActionCommand("7");
    GridBagConstraints gbc_button7 = new GridBagConstraints();
    gbc_button7.fill = GridBagConstraints.BOTH;
    gbc_button7.insets = new Insets(0, 0, 5, 5);
    gbc_button7.gridx = 1;
    gbc_button7.gridy = 3;
    panelStandard.add(button7, gbc_button7);
    
    JButton button8 = new JButton("8");
    button8.setFocusable(false);
    button8.setFocusTraversalKeysEnabled(false);
    button8.setMargin(new Insets(2, 2, 2, 2));
    button8.setActionCommand("8");
    GridBagConstraints gbc_button8 = new GridBagConstraints();
    gbc_button8.fill = GridBagConstraints.BOTH;
    gbc_button8.insets = new Insets(0, 0, 5, 5);
    gbc_button8.gridx = 2;
    gbc_button8.gridy = 3;
    panelStandard.add(button8, gbc_button8);
    
    JButton button9 = new JButton("9");
    button9.setFocusable(false);
    button9.setFocusTraversalKeysEnabled(false);
    button9.setMargin(new Insets(2, 2, 2, 2));
    button9.setActionCommand("9");
    GridBagConstraints gbc_button9 = new GridBagConstraints();
    gbc_button9.fill = GridBagConstraints.BOTH;
    gbc_button9.insets = new Insets(0, 0, 5, 5);
    gbc_button9.gridx = 3;
    gbc_button9.gridy = 3;
    panelStandard.add(button9, gbc_button9);
    
    JButton buttonDivide = new JButton("/");
    buttonDivide.setFocusable(false);
    buttonDivide.setFocusTraversalKeysEnabled(false);
    buttonDivide.setMargin(new Insets(2, 2, 2, 2));
    buttonDivide.setActionCommand("/");
    GridBagConstraints gbc_buttonDivide = new GridBagConstraints();
    gbc_buttonDivide.fill = GridBagConstraints.BOTH;
    gbc_buttonDivide.insets = new Insets(0, 0, 5, 5);
    gbc_buttonDivide.gridx = 4;
    gbc_buttonDivide.gridy = 3;
    panelStandard.add(buttonDivide, gbc_buttonDivide);
    
    JButton buttonBlank = new JButton("");
    buttonBlank.setMargin(new Insets(2, 2, 2, 2));
    buttonBlank.setBackground(Color.WHITE);
    buttonBlank.setEnabled(false);
    GridBagConstraints gbc_buttonBlank = new GridBagConstraints();
    gbc_buttonBlank.fill = GridBagConstraints.BOTH;
    gbc_buttonBlank.insets = new Insets(0, 0, 5, 0);
    gbc_buttonBlank.gridx = 5;
    gbc_buttonBlank.gridy = 3;
    panelStandard.add(buttonBlank, gbc_buttonBlank);
    
    JButton button4 = new JButton("4");
    button4.setFocusable(false);
    button4.setFocusTraversalKeysEnabled(false);
    button4.setMargin(new Insets(2, 2, 2, 2));
    button4.setActionCommand("4");
    GridBagConstraints gbc_button4 = new GridBagConstraints();
    gbc_button4.fill = GridBagConstraints.BOTH;
    gbc_button4.insets = new Insets(0, 0, 5, 5);
    gbc_button4.gridx = 1;
    gbc_button4.gridy = 4;
    panelStandard.add(button4, gbc_button4);
    
    JButton button5 = new JButton("5");
    button5.setFocusable(false);
    button5.setFocusTraversalKeysEnabled(false);
    button5.setMargin(new Insets(2, 2, 2, 2));
    button5.setActionCommand("5");
    GridBagConstraints gbc_button5 = new GridBagConstraints();
    gbc_button5.fill = GridBagConstraints.BOTH;
    gbc_button5.insets = new Insets(0, 0, 5, 5);
    gbc_button5.gridx = 2;
    gbc_button5.gridy = 4;
    panelStandard.add(button5, gbc_button5);
    
    JButton button6 = new JButton("6");
    button6.setFocusable(false);
    button6.setFocusTraversalKeysEnabled(false);
    button6.setMargin(new Insets(2, 2, 2, 2));
    button6.setActionCommand("6");
    GridBagConstraints gbc_button6 = new GridBagConstraints();
    gbc_button6.fill = GridBagConstraints.BOTH;
    gbc_button6.insets = new Insets(0, 0, 5, 5);
    gbc_button6.gridx = 3;
    gbc_button6.gridy = 4;
    panelStandard.add(button6, gbc_button6);
    
    JButton buttonMultiply = new JButton("*");
    buttonMultiply.setFocusable(false);
    buttonMultiply.setFocusTraversalKeysEnabled(false);
    buttonMultiply.setMargin(new Insets(2, 2, 2, 2));
    buttonMultiply.setActionCommand("*");
    GridBagConstraints gbc_buttonMultiply = new GridBagConstraints();
    gbc_buttonMultiply.fill = GridBagConstraints.BOTH;
    gbc_buttonMultiply.insets = new Insets(0, 0, 5, 5);
    gbc_buttonMultiply.gridx = 4;
    gbc_buttonMultiply.gridy = 4;
    panelStandard.add(buttonMultiply, gbc_buttonMultiply);
    
    JButton buttonInverse = new JButton("1/x");
    buttonInverse.setFocusable(false);
    buttonInverse.setFocusTraversalKeysEnabled(false);
    buttonInverse.setMargin(new Insets(2, 2, 2, 2));
    buttonInverse.setActionCommand("reciprocal");
    GridBagConstraints gbc_buttonInverse = new GridBagConstraints();
    gbc_buttonInverse.fill = GridBagConstraints.BOTH;
    gbc_buttonInverse.insets = new Insets(0, 0, 5, 0);
    gbc_buttonInverse.gridx = 5;
    gbc_buttonInverse.gridy = 4;
    panelStandard.add(buttonInverse, gbc_buttonInverse);
    
    JButton button1 = new JButton("1");
    button1.setFocusable(false);
    button1.setFocusTraversalKeysEnabled(false);
    button1.setMargin(new Insets(2, 2, 2, 2));
    button1.setActionCommand("1");
    GridBagConstraints gbc_button1 = new GridBagConstraints();
    gbc_button1.fill = GridBagConstraints.BOTH;
    gbc_button1.insets = new Insets(0, 0, 5, 5);
    gbc_button1.gridx = 1;
    gbc_button1.gridy = 5;
    panelStandard.add(button1, gbc_button1);
    
    JButton button2 = new JButton("2");
    button2.setFocusable(false);
    button2.setFocusTraversalKeysEnabled(false);
    button2.setMargin(new Insets(2, 2, 2, 2));
    button2.setActionCommand("2");
    GridBagConstraints gbc_button2 = new GridBagConstraints();
    gbc_button2.fill = GridBagConstraints.BOTH;
    gbc_button2.insets = new Insets(0, 0, 5, 5);
    gbc_button2.gridx = 2;
    gbc_button2.gridy = 5;
    panelStandard.add(button2, gbc_button2);
    
    JButton button3 = new JButton("3");
    button3.setFocusable(false);
    button3.setFocusTraversalKeysEnabled(false);
    button3.setMargin(new Insets(2, 2, 2, 2));
    button3.setActionCommand("3");
    GridBagConstraints gbc_button3 = new GridBagConstraints();
    gbc_button3.fill = GridBagConstraints.BOTH;
    gbc_button3.insets = new Insets(0, 0, 5, 5);
    gbc_button3.gridx = 3;
    gbc_button3.gridy = 5;
    panelStandard.add(button3, gbc_button3);
    
    JButton buttonSubtract = new JButton("-");
    buttonSubtract.setFocusable(false);
    buttonSubtract.setFocusTraversalKeysEnabled(false);
    buttonSubtract.setMargin(new Insets(2, 2, 2, 2));
    buttonSubtract.setActionCommand("-");
    GridBagConstraints gbc_buttonSubtract = new GridBagConstraints();
    gbc_buttonSubtract.fill = GridBagConstraints.BOTH;
    gbc_buttonSubtract.insets = new Insets(0, 0, 5, 5);
    gbc_buttonSubtract.gridx = 4;
    gbc_buttonSubtract.gridy = 5;
    panelStandard.add(buttonSubtract, gbc_buttonSubtract);
    
    JButton buttonEquals = new JButton("=");
    buttonEquals.setFocusable(false);
    buttonEquals.setFocusTraversalKeysEnabled(false);
    buttonEquals.setMargin(new Insets(2, 2, 2, 2));
    buttonEquals.setActionCommand("=");
    GridBagConstraints gbc_buttonEquals = new GridBagConstraints();
    gbc_buttonEquals.insets = new Insets(0, 0, 5, 0);
    gbc_buttonEquals.gridheight = 2;
    gbc_buttonEquals.fill = GridBagConstraints.BOTH;
    gbc_buttonEquals.gridx = 5;
    gbc_buttonEquals.gridy = 5;
    panelStandard.add(buttonEquals, gbc_buttonEquals);
    
    JButton button0 = new JButton("0");
    button0.setFocusable(false);
    button0.setFocusTraversalKeysEnabled(false);
    button0.setMargin(new Insets(2, 2, 2, 2));
    button0.setActionCommand("0");
    GridBagConstraints gbc_button0 = new GridBagConstraints();
    gbc_button0.insets = new Insets(0, 0, 5, 5);
    gbc_button0.gridwidth = 2;
    gbc_button0.fill = GridBagConstraints.BOTH;
    gbc_button0.gridx = 1;
    gbc_button0.gridy = 6;
    panelStandard.add(button0, gbc_button0);
    
    JButton buttonDecimal = new JButton(".");
    buttonDecimal.setFocusable(false);
    buttonDecimal.setFocusTraversalKeysEnabled(false);
    buttonDecimal.setMargin(new Insets(2, 2, 2, 2));
    buttonDecimal.setActionCommand(".");
    GridBagConstraints gbc_buttonDecimal = new GridBagConstraints();
    gbc_buttonDecimal.fill = GridBagConstraints.BOTH;
    gbc_buttonDecimal.insets = new Insets(0, 0, 5, 5);
    gbc_buttonDecimal.gridx = 3;
    gbc_buttonDecimal.gridy = 6;
    panelStandard.add(buttonDecimal, gbc_buttonDecimal);
    
    JButton buttonPlus = new JButton("+");
    buttonPlus.setFocusable(false);
    buttonPlus.setFocusTraversalKeysEnabled(false);
    buttonPlus.setMargin(new Insets(2, 2, 2, 2));
    buttonPlus.setActionCommand("+");
    GridBagConstraints gbc_buttonPlus = new GridBagConstraints();
    gbc_buttonPlus.fill = GridBagConstraints.BOTH;
    gbc_buttonPlus.insets = new Insets(0, 0, 5, 5);
    gbc_buttonPlus.gridx = 4;
    gbc_buttonPlus.gridy = 6;
    panelStandard.add(buttonPlus, gbc_buttonPlus);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnView = new JMenu("View");
    menuBar.add(mnView);
    
    JRadioButtonMenuItem rdbtnmntmStandard = new JRadioButtonMenuItem("Standard");
    rdbtnmntmStandard.setActionCommand("standard");
    buttonEvents.registerButtonEventHandler(rdbtnmntmStandard);
    buttonGroupView.add(rdbtnmntmStandard);
    mnView.add(rdbtnmntmStandard);
    
    JRadioButtonMenuItem rdbtnmntmScientific = new JRadioButtonMenuItem("Scientific");
    rdbtnmntmScientific.setSelected(true);
    rdbtnmntmScientific.setActionCommand("scientific");
    buttonEvents.registerButtonEventHandler(rdbtnmntmScientific);
    buttonGroupView.add(rdbtnmntmScientific);
    mnView.add(rdbtnmntmScientific);
    
    JMenu mnFormat = new JMenu("Format");
    menuBar.add(mnFormat);
    
    JRadioButtonMenuItem rdbtnmntmDegrees = new JRadioButtonMenuItem("Degrees");
    rdbtnmntmDegrees.setActionCommand("degrees");
    buttonEvents.registerButtonEventHandler(rdbtnmntmDegrees);
    rdbtnmntmDegrees.setSelected(true);
    buttonGroupFormat.add(rdbtnmntmDegrees);
    mnFormat.add(rdbtnmntmDegrees);
    
    JRadioButtonMenuItem rdbtnmntmRadians = new JRadioButtonMenuItem("Radians");
    rdbtnmntmRadians.setActionCommand("radians");
    buttonEvents.registerButtonEventHandler(rdbtnmntmRadians);
    buttonGroupFormat.add(rdbtnmntmRadians);
    mnFormat.add(rdbtnmntmRadians);

    buttonEvents.registerButtonEventHandler(this);
    panelStandard.requestFocusInWindow();
  }
  
  
  class ButtonEventHandler implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("standard")) {
        calculator.clearAll();
        calculator.setLimit(20);
        panelScientificNested.setVisible(false);
        //setSize(275,250);
      } else if (e.getActionCommand().equals("scientific")) {
        calculator.clearAll();
        calculator.setLimit(40);
        panelScientificNested.setVisible(true);
        //setSize(475,250);
      } else if (e.getActionCommand().equals("degrees")) {
        calculator.setFormat(true);
      } else if (e.getActionCommand().equals("radians")) {
        calculator.setFormat(false);
      } else if (e.getActionCommand().equals("pi")) {
        calculator.setPi();
      } else if (e.getActionCommand().equals("0")) {
        calculator.updateInput("0");
      } else if (e.getActionCommand().equals("1")) {
        calculator.updateInput("1");
      } else if (e.getActionCommand().equals("2")) {
        calculator.updateInput("2");
      } else if (e.getActionCommand().equals("3")) {
        calculator.updateInput("3");
      } else if (e.getActionCommand().equals("4")) {
        calculator.updateInput("4");
      } else if (e.getActionCommand().equals("5")) {
        calculator.updateInput("5");
      } else if (e.getActionCommand().equals("6")) {
        calculator.updateInput("6");
      } else if (e.getActionCommand().equals("7")) {
        calculator.updateInput("7");
      } else if (e.getActionCommand().equals("8")) {
        calculator.updateInput("8");
      } else if (e.getActionCommand().equals("9")) {
        calculator.updateInput("9");
      } else if (e.getActionCommand().equals(".")) {
        calculator.insertDecimal();
      } else if (e.getActionCommand().equals("c")) {
        calculator.clearAll();
      } else if (e.getActionCommand().equals("ce")) {
        calculator.clearInput();
      } else if (e.getActionCommand().equals("backspace")) {
        calculator.backspace();
      } else if (e.getActionCommand().equals("negate")) {
        calculator.negate();
      } else if (e.getActionCommand().equals("+")) {
        calculator.add();
      } else if (e.getActionCommand().equals("-")) {
        calculator.subtract();
      } else if (e.getActionCommand().equals("*")) {
        calculator.multiply();
      } else if (e.getActionCommand().equals("/")) {
        calculator.divide();
      } else if (e.getActionCommand().equals("reciprocal")) {
        calculator.reciprocal();
      } else if (e.getActionCommand().equals("sqroot")) {
        calculator.sqroot();
      } else if (e.getActionCommand().equals("cuberoot")) {
        calculator.cuberoot();
      } else if (e.getActionCommand().equals("yroot")) {
        calculator.yroot();
      } else if (e.getActionCommand().equals("square")) {
        calculator.square();
      } else if (e.getActionCommand().equals("cube")) {
        calculator.cube();
      } else if (e.getActionCommand().equals("x2y")) {
        calculator.xy();
      } else if (e.getActionCommand().equals("mod")) {
        calculator.mod();
      } else if (e.getActionCommand().equals("10x")) {
        calculator.tenX();
      } else if (e.getActionCommand().equals("log")) {
        calculator.log();
      } else if (e.getActionCommand().equals("exp")) {
        calculator.log();
      } else if (e.getActionCommand().equals("ln")) {
        calculator.ln();
      } else if (e.getActionCommand().equals("factorial")) {
        calculator.factorial();
      } else if (e.getActionCommand().equals("cos")) {
        calculator.cos();
      } else if (e.getActionCommand().equals("sin")) {
        calculator.sin();
      } else if (e.getActionCommand().equals("tan")) {
        calculator.tan();
      } else if (e.getActionCommand().equals("acos")) {
        calculator.acos();
      } else if (e.getActionCommand().equals("asin")) {
        calculator.asin();
      } else if (e.getActionCommand().equals("atan")) {
        calculator.atan();
      } else if (e.getActionCommand().equals("=")) {
        calculator.equal();
      }
      textAreaOutputFormula.setText(calculator.getDisplayFormula());
      textAreaOutput.setText(calculator.getDisplay());
    }
    
    public void registerButtonEventHandler(JRadioButtonMenuItem menuButton) {
      menuButton.addActionListener(this);
    }
    
    public void registerButtonEventHandler(Component comp) {
      if (comp != null) {
        if (comp instanceof JButton) {
          JButton button = (JButton)comp;
          button.addActionListener(this);
        } else if (comp instanceof Container){
          Container container = (Container)comp;
          int n = container.getComponentCount();
          for (int i = 0; i < n; i++) 
            registerButtonEventHandler(container.getComponent(i));
        }
      }
    }
  }
  
  class KeyBoardEventHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) { 
          case KeyEvent.VK_0: case KeyEvent.VK_NUMPAD0:
        calculator.updateInput("0");
              break;
          case KeyEvent.VK_1: case KeyEvent.VK_NUMPAD1:
        calculator.updateInput("1");
              break;
          case KeyEvent.VK_2: case KeyEvent.VK_NUMPAD2:
        calculator.updateInput("2");
              break;
          case KeyEvent.VK_3: case KeyEvent.VK_NUMPAD3:
        calculator.updateInput("3");
              break;
          case KeyEvent.VK_4: case KeyEvent.VK_NUMPAD4:
        calculator.updateInput("4");
              break;
          case KeyEvent.VK_5: case KeyEvent.VK_NUMPAD5:
        calculator.updateInput("5");
              break;
          case KeyEvent.VK_6: case KeyEvent.VK_NUMPAD6:
        calculator.updateInput("6");
              break;
          case KeyEvent.VK_7: case KeyEvent.VK_NUMPAD7:
        calculator.updateInput("7");
              break;
          case KeyEvent.VK_8: case KeyEvent.VK_NUMPAD8:
        calculator.updateInput("8");
              break;
          case KeyEvent.VK_9: case KeyEvent.VK_NUMPAD9:
        calculator.updateInput("9");
              break;
          case KeyEvent.VK_ADD: case KeyEvent.VK_PLUS:
        calculator.add();
              break;
          case KeyEvent.VK_SUBTRACT: case KeyEvent.VK_MINUS:
        calculator.subtract();
              break;
          case KeyEvent.VK_MULTIPLY: case KeyEvent.VK_ASTERISK:
        calculator.multiply();
              break;
          case KeyEvent.VK_DIVIDE: case KeyEvent.VK_SLASH:
        calculator.divide();
              break;
          case KeyEvent.VK_ENTER:
        calculator.equal();
              break;
        }
      textAreaOutputFormula.setText(calculator.getDisplayFormula());
      textAreaOutput.setText(calculator.getDisplay());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
  }
}















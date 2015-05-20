package gui;

import gen.WorDeLLexer;
import gen.WorDeLParser;
import gen.WorDeLParser.ContentContext;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import representation.nodes.FlowNode;
import support.CustomErrorListener;
import support.ErrorRepository;

public class MainFrame extends JFrame implements ActionListener,
		MouseWheelListener, MouseListener, ComponentListener {

	private JPanel contentPane;
	private JScrollPane scroll;
	private JButton btnProcess;
	private JTextArea textArea;
	private DrawPanel canvas;
	private int sizeX = 1250;
	private int sizeY = 730;
	private JPanel scrollHolder;
	private JTextArea errorArea;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, this.sizeX, this.sizeY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*************** text area ******************/
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 375, 393);
		contentPane.add(panel);
		panel.setLayout(null);

		textArea = new JTextArea();
		JScrollPane textHolder = new JScrollPane(textArea);
		textHolder.setBounds(0, 0, 375, 393);
		panel.add(textHolder);
		/********************************************/
		/*************** error area ******************/
		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.setBounds(10, 410, 375, 240);
		contentPane.add(panel2);
		panel2.setLayout(null);

		errorArea = new JTextArea();
		JScrollPane errorAreaHolder = new JScrollPane(errorArea);
		errorAreaHolder.setBounds(0, 0, 375, 240);
		panel2.add(errorAreaHolder);
		/********************************************/

		scrollHolder = new JPanel();
		scrollHolder.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollHolder.setBounds(395, 11, 830, 670);

		canvas = new DrawPanel(10000, 10000);
		scroll = new JScrollPane(canvas,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.getHorizontalScrollBar().setUnitIncrement(16);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.setPreferredSize(new Dimension(825, 660));

		scrollHolder.add(scroll, BorderLayout.CENTER);

		contentPane.add(scrollHolder);

		btnProcess = new JButton("Process");
		btnProcess.setBounds(296, 655, 89, 23);
		btnProcess.addActionListener(this);
		contentPane.add(btnProcess);

		String ss = readFile("src\\Input.txt");
		this.textArea.append(ss);
		canvas.addMouseListener(this);
		canvas.addMouseWheelListener(this);

		addComponentListener(this);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj == this.btnProcess) {
			// this.canvas.reset();
			WorDeLLexer lexer = new WorDeLLexer(new ANTLRInputStream(
					this.textArea.getText()));
			// String ss = readFile("src\\Input.txt");
			// FirstLexer lexer = new FirstLexer(new ANTLRInputStream(ss));
			// lexer.reset();
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			WorDeLParser parser = new WorDeLParser(tokens);
			parser.addErrorListener(new CustomErrorListener());
			ContentContext result = parser.content();
			Map<String, FlowNode> aa = result.flows;
			Collection<FlowNode> rr = aa.values();
			Iterator<FlowNode> i = rr.iterator();
			canvas.setFlows(rr);

			// add error report
			errorArea.setText("");
			List<support.Error> errors = ErrorRepository.getErrorList();
			for (support.Error e : errors) {
				errorArea.append(e.toString() + "\n");
				System.out.println(e.toString());
			}
		}
		repaint();
	}

	static String readFile(String path) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(encoded);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		if (notches < 0) {
			canvas.zoomIn();
		} else if (notches > 0) {
			canvas.zoomOut();
		}
		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * canvas.zoomIn();
		 * System.out.println("zzzzzzzzzzzzzzzzzzzzzooooooooooom"); repaint();
		 */
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent e) {
		//
		// Dimension d = this.getSize();
		// sizeX = d.width;
		// sizeY = d.height;
		// // scrollHolder.setBounds(395, 11,sizeX - 395 - 26, 620);
		// contentPane.remove(scrollHolder);
		// scrollHolder = new JPanel();
		// scrollHolder.setBorder(new LineBorder(new Color(0, 0, 0)));
		// scrollHolder.setBounds(395, 11, sizeX - 395 - 26, sizeY - 50);
		//
		// canvas = new DrawPanel(10000, 10000);
		// scroll = new JScrollPane(canvas,
		// ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		// ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// scroll.getHorizontalScrollBar().setUnitIncrement(16);
		// scroll.getVerticalScrollBar().setUnitIncrement(16);
		// scroll.setPreferredSize(new Dimension(sizeX - 395 - 26 - 10, sizeY -
		// 60));
		//
		// scrollHolder.add(scroll, BorderLayout.CENTER);
		//
		// contentPane.add(scrollHolder);
		// System.out.println(d.getWidth() + ":" + d.getHeight());
		// repaint();

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// UIManager.setLookAndFeel(UIManager
					// .getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

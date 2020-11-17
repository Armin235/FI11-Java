import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class View
{

	private JFrame frame;
	protected JList list_Korb;
	protected JComboBox comboBox_Pizza;
	protected JComboBox comboBox_Grosse;
	protected JComboBox comboBox_Extra;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_add;
	private JButton btnNewButton_sub;
	private JLabel lblNewLabel_Preis;
	protected JLabel lblNewLabel_Summe;

	private Controll controll;

	public View(Controll controll)
	{
		initialize();
		this.controll = controll;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getList_Korb());
		frame.getContentPane().add(getComboBox_Pizza());
		frame.getContentPane().add(getComboBox_Grosse());
		frame.getContentPane().add(getComboBox_Extra());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnNewButton_add());
		frame.getContentPane().add(getBtnNewButton_sub());
		frame.getContentPane().add(getLblNewLabel_Preis());
		frame.getContentPane().add(getLblNewLabel_Summe());
		frame.setVisible(true);
	}

	protected JList getList_Korb()
	{
		if (list_Korb == null)
		{
			list_Korb = new JList();
			list_Korb.setBounds(10, 77, 315, 143);
		}
		return list_Korb;
	}

	protected JComboBox getComboBox_Pizza()
	{
		if (comboBox_Pizza == null)
		{
			comboBox_Pizza = new JComboBox();
			comboBox_Pizza.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					controll.grosseUpdate((Pizza)comboBox_Grosse.getSelectedItem());
					controll.extraUpdate((Pizza)comboBox_Extra.getSelectedItem());
				}
			});
			comboBox_Pizza.setBounds(53, 11, 155, 22);
		}
		return comboBox_Pizza;
	}

	protected JComboBox getComboBox_Grosse()
	{
		if (comboBox_Grosse == null)
		{
			comboBox_Grosse = new JComboBox();
			comboBox_Grosse.setBounds(274, 11, 98, 22);
		}
		return comboBox_Grosse;
	}

	protected JComboBox getComboBox_Extra()
	{
		if (comboBox_Extra == null)
		{
			comboBox_Extra = new JComboBox();
			comboBox_Extra.setBounds(53, 44, 155, 22);
		}
		return comboBox_Extra;
	}

	private JLabel getLblNewLabel()
	{
		if (lblNewLabel == null)
		{
			lblNewLabel = new JLabel("Pizza:");
			lblNewLabel.setBounds(10, 15, 46, 14);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1()
	{
		if (lblNewLabel_1 == null)
		{
			lblNewLabel_1 = new JLabel("Gr\u00F6\u00DFe:");
			lblNewLabel_1.setBounds(218, 15, 46, 14);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2()
	{
		if (lblNewLabel_2 == null)
		{
			lblNewLabel_2 = new JLabel("Extras:");
			lblNewLabel_2.setBounds(10, 48, 46, 14);
		}
		return lblNewLabel_2;
	}
	
	public void setBtnHinzufuegenListener (ActionListener l)
	{
		this.btnNewButton_add.addActionListener(l);
	}

	private JButton getBtnNewButton_add()
	{
		if (btnNewButton_add == null)
		{
			btnNewButton_add = new JButton("Hinzuf\u00FCgen");
			/*btnNewButton_add.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					controll.warenkorbUpdate(comboBox_Pizza.getSelectedItem(), comboBox_Grosse.getSelectedItem(), comboBox_Extra.getSelectedItem());
				}
			});*/
			btnNewButton_add.setBounds(335, 76, 89, 23);
		}
		return btnNewButton_add;
	}
	
	public void setBtnEntfernenListener (ActionListener l)
	{
		this.btnNewButton_sub.addActionListener(l);
	}
	
	

	private JButton getBtnNewButton_sub()
	{
		if (btnNewButton_sub == null)
		{
			btnNewButton_sub = new JButton("Entfernen");
			/*btnNewButton_sub.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					controll.entfernenWK(list_Korb.getSelectedValue());
				}
			});*/
			btnNewButton_sub.setBounds(335, 110, 89, 23);
		}
		return btnNewButton_sub;
	}

	private JLabel getLblNewLabel_Preis()
	{
		if (lblNewLabel_Preis == null)
		{
			lblNewLabel_Preis = new JLabel("Gesamtpreis:");
			lblNewLabel_Preis.setBounds(10, 231, 90, 14);
		}
		return lblNewLabel_Preis;
	}

	protected JLabel getLblNewLabel_Summe()
	{
		if (lblNewLabel_Summe == null)
		{
			lblNewLabel_Summe = new JLabel("--.--");
			lblNewLabel_Summe.setBounds(119, 231, 75, 14);
		}
		return lblNewLabel_Summe;
	}
}

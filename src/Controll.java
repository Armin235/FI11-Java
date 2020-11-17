import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import com.sun.java.accessibility.util.GUIInitializedListener;
//import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;

import java.io.*;

public class Controll
{
	private View gui;

	private DefaultComboBoxModel<Pizza> listePizza = new DefaultComboBoxModel();
	private DefaultComboBoxModel<Grosse> listeGrosse = new DefaultComboBoxModel();
	private DefaultComboBoxModel<Extras> listeExtras = new DefaultComboBoxModel();

	private DefaultListModel<WahrenKorb> listeBestellung = new DefaultListModel<>();
	private ArrayList<WahrenKorb> bestellListe = new ArrayList<>();

	public Controll()
	{
		this.gui = new View(this);
		hinzufuegen();
		
		starten();
		addListener();
		grosseUpdate(listePizza.getElementAt(0));
		extraUpdate(listePizza.getElementAt(0));
		hinzufuegen2();
	}

	// zuweisung zur gui
	public void starten()
	{
		gui.getComboBox_Pizza().setModel(listePizza);
		gui.getList_Korb().setModel(listeBestellung);
		gui.getComboBox_Extra().setModel(listeExtras);
		gui.getComboBox_Grosse().setModel(listeGrosse);
	}

	public void addListener()
	{
		this.gui.setBtnHinzufuegenListener(new BtnHinzufuegenListener());
		this.gui.setBtnEntfernenListener(new BtnEntfernenListener());
	}

	class BtnHinzufuegenListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			warenkorbUpdate(gui.getComboBox_Pizza().getSelectedItem(), gui.getComboBox_Grosse().getSelectedItem(),
					gui.getComboBox_Extra().getSelectedItem());
		}

	}

	class BtnEntfernenListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			entfernenWK(gui.getList_Korb().getSelectedValue());
		}

	}

	// objecte erstellen
	public void hinzufuegen()
	{
		ArrayList<Grosse> temp = new ArrayList<Grosse>();
		temp.add(new Grosse("klein", 3.00));
		temp.add(new Grosse("mittel", 5.00));
		temp.add(new Grosse("gross", 7.00));

		ArrayList<Extras> temp2 = new ArrayList<Extras>();
		temp2.add(new Extras("k‰se", 4.50));
		temp2.add(new Extras("Bacon", 4.50));
		temp2.add(new Extras("Chilli", 4.50));

		Pizza salami = new Pizza("Salami", temp, temp2);

		temp = new ArrayList<Grosse>();
		temp.add(new Grosse("Familie", 12.00));
		temp.add(new Grosse("Party", 15.00));

		Pizza spezial = new Pizza("Spezial", temp, temp2);

		temp = new ArrayList<Grosse>();
		temp.add(new Grosse("S", 5.00));
		temp.add(new Grosse("M", 7.00));
		temp.add(new Grosse("L", 8.00));

		Pizza funghi = new Pizza("Funghi", temp, temp2);

		listePizza.addElement(salami);
		listePizza.addElement(spezial);
		listePizza.addElement(funghi);
	}

	public void hinzufuegen2()
	{
		try
		{
			String zeile = null;
			String name = null;
			double preis = 0;
			BufferedReader in = new BufferedReader(new FileReader("H:\\Java\\Workspace\\Pizza GUI true\\bin\\Speisekarte"));
			ArrayList<Grosse> temp = new ArrayList<Grosse>();
			ArrayList<Extras> temp2 = new ArrayList<Extras>();
			temp2.add(new Extras("k‰se", 4.50));
			temp2.add(new Extras("Bacon", 4.50));
			temp2.add(new Extras("Chilli", 4.50));
			
			try
			{
				for (int i = 0; i < 7; i++)
				{
					while ((zeile = in.readLine()) != ";")
					{
						name = zeile;
					}
					Pizza name1 = new Pizza(name, temp, temp2);
					
					temp = new ArrayList<Grosse>();
					
					while ((zeile = in.readLine()) != ";")
					{
						preis = Double.valueOf(zeile);
					}	
					temp.add(new Grosse("Groﬂ", preis));
				
					while ((zeile = in.readLine()) != ";")
					{
						preis = Double.valueOf(zeile);
					}
					temp.add(new Grosse("Mittel", preis));
				
					while ((zeile = in.readLine()) != null)
					{
						preis = Double.valueOf(zeile);
					}
					temp.add(new Grosse("Klein", preis));
				}
				
			} 
			catch (IOException e)
			{
				System.out.println("Fehler2");
			}
			finally
			{
				in.close();
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Fehler: FileNotFoundException");
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			System.out.println("Fehler: IOException1");
		}
		
		

	}

	public void grosseUpdate(Pizza pizza)
	{
		listeGrosse.removeAllElements();
		for (Grosse grosse : pizza.getGroesse())
		{
			listeGrosse.addElement(grosse);
		}
	}

	public void extraUpdate(Pizza pizza)
	{
		listeExtras.removeAllElements();
		for (Extras extras : pizza.getExtras())
		{
			listeExtras.addElement(extras);
		}
	}

	public void warenkorbUpdate(Object object, Object object2, Object object3)
	{
		WahrenKorb test = new WahrenKorb((Pizza) object, (Grosse) object2, (Extras) object3);
		listeBestellung.addElement(test);
		bestellListe.add(test);
		berechnen();
	}

	public void entfernenWK(Object object)
	{
		listeBestellung.removeElement((WahrenKorb) object);
		bestellListe.remove((WahrenKorb) object);
		berechnen();
	}

	public void berechnen()
	{
		double gesamtpreis = 0;

		for (WahrenKorb w : bestellListe)
		{
			gesamtpreis = gesamtpreis + w.getGrosse().getPreis() + w.getExtras().getPreis();
		}

		String test = Double.toString(gesamtpreis);

		gui.getLblNewLabel_Summe().setText(test);
	}

}

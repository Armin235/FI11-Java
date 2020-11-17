import java.util.ArrayList;

public class Pizza
{
	private String name;
	private ArrayList<Grosse> groesse;
	private ArrayList<Extras> extras;

	

	public Pizza(String name, ArrayList<Grosse> groesse, ArrayList<Extras> extras)
	{
		super();
		this.name = name;
		this.groesse = groesse;
		this.extras = extras;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	

	public ArrayList<Grosse> getGroesse()
	{
		return groesse;
	}

	public void setGroesse(ArrayList<Grosse> groesse)
	{
		this.groesse = groesse;
	}

	public ArrayList<Extras> getExtras()
	{
		return extras;
	}

	public void setExtras(ArrayList<Extras> extras)
	{
		this.extras = extras;
	}

	@Override
	public String toString()
	{
		return name;
	}

}

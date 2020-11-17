
public class WahrenKorb
{
	private Pizza pizza;
	private Grosse grosse;
	private Extras extras;

	public WahrenKorb(Pizza pizza, Grosse grosse, Extras extras)
	{
		super();
		this.pizza = pizza;
		this.grosse = grosse;
		this.extras = extras;
	}

	public Pizza getPizza()
	{
		return pizza;
	}

	public void setPizza(Pizza pizza)
	{
		this.pizza = pizza;
	}

	public Grosse getGrosse()
	{
		return grosse;
	}

	public void setGrosse(Grosse grosse)
	{
		this.grosse = grosse;
	}

	public Extras getExtras()
	{
		return extras;
	}

	public void setExtras(Extras extras)
	{
		this.extras = extras;
	}

	@Override
	public String toString()
	{
		return pizza + " | " + grosse + " | " + extras;
	}

//	
}

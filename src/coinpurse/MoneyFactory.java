package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public abstract class MoneyFactory {
	protected static MoneyFactory factory = null ;

	
	protected MoneyFactory() {
		
	}
	
	public static MoneyFactory getInstance(){
		if(factory == null ) factory = new ThaiMoneyFactory() ;
		return factory;
	}
	public abstract Valuable createMoney(double value);
	public Valuable createMoney(String value){
		return createMoney(Double.parseDouble(value));
	}
	static void setMoneyFactory(MoneyFactory moneyFactory){
		factory = moneyFactory;
	}
	
}

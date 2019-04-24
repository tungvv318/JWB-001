package com.anonyhostvn.model;

import java.util.ArrayList;
import java.util.List;
import com.anonyhostvn.model.InfoPattern; 

public class MocksData {
	private int RecentID ; 
	private List<InfoPattern> membership ;
	
	public MocksData() {
		this.membership = new ArrayList<InfoPattern>(); 
		this.membership.add(new InfoPattern(1, "Nguyen Hai Long", "emailGoogle@gmail.com", "0912345678", 1000, true)) ; 
		this.membership.add(new InfoPattern(2, "Nguyen Tat Dat" , "emailMicrosoft@microF.com", "081234567", 2000, true)) ; 
		this.membership.add(new InfoPattern(3, "Tran Manh Hieu" , "emailAmazone@Amaz.com", "071234567", 3000, false)) ;
		this.membership.add(new InfoPattern(4, "Nguyen Do Duong" , "emailSpaceX@spaceX.com", "061234567", 4000, false)) ;
		this.RecentID = 4 ; 
	} 
	
	public boolean TransferMoney (int FromID , int ToID , int money) {
		if (FromID > this.RecentID || FromID <= 0 || ToID > this.RecentID || ToID < 0) return false ; 
		if (FromID == ToID) return false ; 
 	
		for (InfoPattern temp : membership) {
			if (temp.getID() == FromID) {
				if (!temp.Submoney(money)) return false ; 
			} else if (temp.getID() == ToID) {
				temp.PlusMoney(money) ; 
			}
		}
		
		return true ; 
	}
	
	public int ValidateLogin(String email , String pass) { 
		for (InfoPattern temp : this.membership) {
			if (temp.getEmail().equals(email) && temp.getPassword().equals(pass)) return temp.getID() ;
		}
		
		return 0 ; 
	}
	
	public InfoPattern getUser(int ID) {
		InfoPattern Result = new InfoPattern(0 , "" , "" , "" , 0 , false) ;  
		for (InfoPattern temp : this.membership) {
			if (temp.getID() == ID) Result = temp ;  
		}
		return Result ; 
	}
	
	public void AddNewMember(String name , String email , String phone , int balance , boolean status) {
		this.RecentID ++ ; 
		membership.add(new InfoPattern(this.RecentID, name, email, phone, balance, status)) ; 
	}
	
	public void RemoveMembre(int ID) {
		for (int i = 0; i < membership.size(); i++) if (this.membership.get(i).getID() == ID) {
			InfoPattern NeedRemove = membership.get(i) ; 
			membership.remove(NeedRemove) ;
		}
	}

	public List<InfoPattern> getMembership() {
		return membership;
	}

	public void setMembership(List<InfoPattern> membership) {
		this.membership = membership;
	}
	
	
}

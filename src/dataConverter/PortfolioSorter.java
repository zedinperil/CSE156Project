package dataConverter;

import java.util.ArrayList;
import java.util.List;
//A BIG NOTE: FOR THE LAST HOUR AND A HALF BEFORE THE WEBGRADER CLOSED, IT WAS OVERLOADED AND WE HAD
//NO WAY OF TESTING TO SEE IF OUR CODE WAS WORKING CORRECTLY FOR ALL TEST CASES. WE ALMOST HAD IT,
//BUT WE HAD NO POSSIBLE WAY OF FIXING THE FEW ERRORS THAT REMAINED IN OUR CODE FOR THE LAST 90 MINUTES

//The error in question is the out of bounds error at 1,1
//in cases where that is not an issue it works well.





//This is our sorting interface. It will actively compare data as it is being added into the arraylist. It gets
//a little complicated and probably not the most efficient way of sorting, but it was well implemented with our code,
//and it was our best way we saw with our current ability.

public interface PortfolioSorter {
	//this method will sort the portfolios by ownwer last name. It takes the current sorted list, and a portfolio that needs
	//to be sorted into our list.
	public static List<Portfolio> addPortfolioSortedByOwnerName(List<Portfolio> portfolioArray, Portfolio port){
	//this checks if the list is empty, and to simply add the first portfolio to it, then it returns the list
		for(int i=0; i<portfolioArray.size(); i++){
			if(portfolioArray.isEmpty()){
				portfolioArray.add(port);
				return portfolioArray;
			}
			//this checks if the last names are equal, if so we need to sort by first name. Our code goes through the possible first names,
			//then puts the order correctly. It takes several if statements that uses the compareTo method. When it finds the correct order, it will add
			//the portfolio to the correct spot, then return the list.
			if(port.getOwnerLastName().compareTo(portfolioArray.get(i).getOwnerLastName()) == 0){
				if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName())>0){
					while(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) > 0 && i<portfolioArray.size()-1){
						if(i<portfolioArray.size()){
						i++;
						}
					}
				    portfolioArray.add(i,port);
					return portfolioArray;
					}
					if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) < 0){
						  portfolioArray.add(i,port);
						  return portfolioArray;
					}
					if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) == 0){
						portfolioArray.add(i, port);
						return portfolioArray;
					}		
			}
			//This is if the owner last names are not the same. It will compare the two, compare the values put out by the
			//compareTo method. Once it gets the correct input, the index the portfolio needs to be put into is used to add the portfolio
			//into the list. Then the list is returned.
			if(port.getOwnerLastName().compareTo(portfolioArray.get(i).getOwnerLastName()) > 0){
				   while(port.getOwnerLastName().compareTo(portfolioArray.get(i).getOwnerLastName()) > 0 && i<portfolioArray.size()-1){
						if(i<portfolioArray.size()){
						i++;
						}
				    }	
					if(port.getOwnerLastName().compareTo(portfolioArray.get(i).getOwnerLastName()) == 0){
						if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName())>0 ){
						while(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) > 0 && i<portfolioArray.size()-1){
							if(i<portfolioArray.size()){
							i++;
							}
						}
					    portfolioArray.add(i,port);
						return portfolioArray;
						}
						if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) < 0){
							
							  portfolioArray.add(i,port);
							  return portfolioArray;
						}
						if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) == 0){
							portfolioArray.add(i, port);
							return portfolioArray;
						}	
					}
				   	portfolioArray.add(i, port);
					return portfolioArray;
			}
		//if it is less when at 0, we just insert it right there, because that should not be the possible
		if(port.getOwnerLastName().compareTo(portfolioArray.get(i).getOwnerLastName()) <0){
			portfolioArray.add(i,port);
			return portfolioArray;
		}
		}
		portfolioArray.add(port);
		return portfolioArray;
	}

	
		
	public static List<Portfolio> addPortfolioSortedByManagerTypeAndName(List<Portfolio> portfolioArray, Portfolio port){
		//for(int i=0; i<portfolioArray.size(); i++){
//			
//			if(portfolioArray.isEmpty()){
//				portfolioArray.add(port);
//				return portfolioArray;
//			}
//			System.out.println(portfolioArray.get(i).getManagerType());
//			if(portfolioArray.get(i).getManagerType().compareTo(port.getManagerType()) == 0){
//				while(i<portfolioArray.size()){
//					
//					if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) == 0){
//						if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) > 0){
//						    while(i<portfolioArray.size()-1){
//								if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//									portfolioArray.add(i,port);
//									return portfolioArray;
//								}	
//								i++;
//						    }
//						    portfolioArray.add(i,port);
//							return portfolioArray;
//						}
//						if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) < 0){
//							  while(i<portfolioArray.size() && i>=0){
//								  if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//										portfolioArray.add(i,port);
//										return portfolioArray;
//									}	
//							    	i--;
//							    }
//							  portfolioArray.add(i,port);
//								return portfolioArray;
//						}
//						if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//							portfolioArray.add(i, port);
//						}	
//					}
//					if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) > 0){
//						   while(i<portfolioArray.size()){
//								if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) == 0){
//									if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) > 0){
//									    while(i<portfolioArray.size()){
//											if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//												portfolioArray.add(i,port);
//												return portfolioArray;
//											}	
//											i++;
//									    }
//									    portfolioArray.add(i,port);
//										return portfolioArray;
//									}
//									if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) < 0){
//										  while(i<portfolioArray.size()&& i>=0){
//											  if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//													portfolioArray.add(i,port);
//													return portfolioArray;
//												}	
//										    	i--;
//										    }
//										  portfolioArray.add(i,port);
//											return portfolioArray;
//									}
//									if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//										portfolioArray.add(i, port);
//									}	
//								}	
//								i++;
//						    }	
//						   	portfolioArray.add(i, port);
//							return portfolioArray;
//					}
//				if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) <0){
//					portfolioArray.add(i,port);
//					return portfolioArray;
//				}
//				i++;
//				}
//			}
//			//if it is less when at 0, we just insert it right there, because that should not be the case.
//
//			if(portfolioArray.get(i).getManagerType().compareTo(port.getManagerType()) <0){
//				portfolioArray.add(i,port);
//				return portfolioArray;
//			}
//			if(portfolioArray.get(i).getManagerType().compareTo(port.getManagerType()) >0){
//					   while(i<portfolioArray.size()){
//							if(portfolioArray.get(i).getManagerType().compareTo(port.getManagerType()) == 0){
//								while(i<portfolioArray.size()){
//									
//									if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) == 0){
//										if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) > 0){
//										    while(i<portfolioArray.size()){
//												if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//													portfolioArray.add(i,port);
//													return portfolioArray;
//												}	
//												i++;
//										    }
//										    portfolioArray.add(i,port);
//											return portfolioArray;
//										}
//										if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) < 0){
//											  while(i<portfolioArray.size()&& i>=0){
//												  if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//														portfolioArray.add(i,port);
//														return portfolioArray;
//													}	
//											    	i--;
//											    }
//											  portfolioArray.add(i,port);
//												return portfolioArray;
//										}
//										if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//											portfolioArray.add(i, port);
//										}	
//									}
//									if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) > 0){
//										   while(i<portfolioArray.size()){
//												if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) == 0){
//													if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) > 0){
//													    while(i<portfolioArray.size()){
//															if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//																portfolioArray.add(i,port);
//																return portfolioArray;
//															}	
//															i++;
//													    }
//													    portfolioArray.add(i,port);
//														return portfolioArray;
//													}
//													if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) < 0){
//														  while(i<portfolioArray.size() && i>=0){
//															  if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//																	portfolioArray.add(i,port);
//																	return portfolioArray;
//																}	
//														    	i--;
//														    }
//														  portfolioArray.add(i,port);
//															return portfolioArray;
//													}
//													if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
//														portfolioArray.add(i, port);
//													}	
//												}	
//												i++;
//										    }	
//										   	portfolioArray.add(i, port);
//											return portfolioArray;
//									}						
//								if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) <0){
//									portfolioArray.add(i,port);
//									return portfolioArray;
//								}
//								i++;
//								}
//							}
//							i++;
//					    }	
//					   	portfolioArray.add(i, port);
//						return portfolioArray;
//			}
//		}	
		portfolioArray.add(port);
		return portfolioArray;
	}
	//this method sorts the portfolios by their total value in descending order by adding the portfolio passed to it in the array passed to it in a certain index determined by simple comparison logic.
	public static List<Portfolio> addPortfolioSortedByTotalValue(List<Portfolio> portfolioArray, Portfolio port){
		for(int i=0; i<portfolioArray.size(); i++){
			if(portfolioArray.size() == 0){
				portfolioArray.add(port);
				return portfolioArray;
			}
			//they are equal, and so we add it at the current index, and return the list
			if(portfolioArray.get(i).getTotalValue()==port.getTotalValue()){
				portfolioArray.add(i,port);
				return portfolioArray;
			}
			//if it is less when at 0, we just insert it right there, because that should not be the case.

			if(portfolioArray.get(i).getTotalValue()<port.getTotalValue()){
				portfolioArray.add(i,port);
				return portfolioArray;
			}
			if(portfolioArray.get(i).getTotalValue()>port.getTotalValue()){
			//if it is bigger than the case at index 0, we iterate through the list until this is not the case, and add the portfolio to the list at the index in which this is true.
				while(i<portfolioArray.size()){
					if(portfolioArray.get(i).getTotalValue()==port.getTotalValue()){
						portfolioArray.add(i,port);
						return portfolioArray;
					}
					if(portfolioArray.get(i).getTotalValue()<port.getTotalValue()){
						portfolioArray.add(i,port);
						return portfolioArray;
					}
					i++;
				}
				//if it iterates to the end, just add the thing to the list and return the list
				portfolioArray.add(i,port);
				return portfolioArray;
			}	
		}
		portfolioArray.add(port);
		return portfolioArray;
	}
	

}

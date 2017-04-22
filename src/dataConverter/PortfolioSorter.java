package dataConverter;

import java.util.ArrayList;
import java.util.List;
//A BIG NOTE: FOR THE LAST HOUR AND A HALF BEFORE THE WEBGRADER CLOSED, IT WAS OVERLOADED AND WE HAD
//NO WAY OF TESTING TO SEE IF OUR CODE WAS WORKING CORRECTLY FOR ALL TEST CASES. WE ALMOST HAD IT,
//BUT WE HAD NO POSSIBLE WAY OF FIXING THE FEW ERRORS THAT REMAINED IN OUR CODE FOR THE LAST 90 MINUTES

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
					while(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) > 0){
						if(i<portfolioArray.size()){
						i++;
						}
					}
				    portfolioArray.add(i,port);
					return portfolioArray;
					}
					if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) < 0){
						  while(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) < 0&& i>=0){	
						    	i--;
						    }
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
				   while(port.getOwnerLastName().compareTo(portfolioArray.get(i).getOwnerLastName()) > 0 && i<portfolioArray.size()){
						if(i<portfolioArray.size()){
						i++;
						}
				    }	
					if(port.getOwnerLastName().compareTo(portfolioArray.get(i).getOwnerLastName()) == 0){
						if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName())>0 ){
						while(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) > 0 && i<portfolioArray.size()){
							if(i<portfolioArray.size()){
							i++;
							}
						}
					    portfolioArray.add(i,port);
						return portfolioArray;
						}
						if(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) < 0){
							  while(port.getOwnerFirstName().compareTo(portfolioArray.get(i).getOwnerFirstName()) < 0&& i>=0){	
							    	i--;
							    }
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
		
		if(port.getOwnerLastName().compareTo(portfolioArray.get(i).getOwnerLastName()) <0){
			portfolioArray.add(i,port);
			return portfolioArray;
		}
		}
		portfolioArray.add(port);
		return portfolioArray;
	}

	
		
	public static List<Portfolio> addPortfolioSortedByManagerTypeAndName(List<Portfolio> portfolioArray, Portfolio port){
		for(int i=0; i<portfolioArray.size(); i++){
			
			if(portfolioArray.isEmpty()){
				portfolioArray.add(port);
				return portfolioArray;
			}
			System.out.println(portfolioArray.get(i).getManagerType());
			if(portfolioArray.get(i).getManagerType().compareTo(port.getManagerType()) == 0){
				while(i<portfolioArray.size()){
					
					if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) == 0){
						if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) > 0){
						    while(i<portfolioArray.size()-1){
								if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
									portfolioArray.add(i,port);
									return portfolioArray;
								}	
								i++;
						    }
						    portfolioArray.add(i,port);
							return portfolioArray;
						}
						if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) < 0){
							  while(i<portfolioArray.size() && i>=0){
								  if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
										portfolioArray.add(i,port);
										return portfolioArray;
									}	
							    	i--;
							    }
							  portfolioArray.add(i,port);
								return portfolioArray;
						}
						if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
							portfolioArray.add(i, port);
						}	
					}
					if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) > 0){
						   while(i<portfolioArray.size()){
								if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) == 0){
									if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) > 0){
									    while(i<portfolioArray.size()){
											if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
												portfolioArray.add(i,port);
												return portfolioArray;
											}	
											i++;
									    }
									    portfolioArray.add(i,port);
										return portfolioArray;
									}
									if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) < 0){
										  while(i<portfolioArray.size()&& i>=0){
											  if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
													portfolioArray.add(i,port);
													return portfolioArray;
												}	
										    	i--;
										    }
										  portfolioArray.add(i,port);
											return portfolioArray;
									}
									if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
										portfolioArray.add(i, port);
									}	
								}	
								i++;
						    }	
						   	portfolioArray.add(i, port);
							return portfolioArray;
					}
				if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) <0){
					portfolioArray.add(i,port);
					return portfolioArray;
				}
				i++;
				}
			}
			if(portfolioArray.get(i).getManagerType().compareTo(port.getManagerType()) <0){
				portfolioArray.add(i,port);
				return portfolioArray;
			}
			if(portfolioArray.get(i).getManagerType().compareTo(port.getManagerType()) >0){
					   while(i<portfolioArray.size()){
							if(portfolioArray.get(i).getManagerType().compareTo(port.getManagerType()) == 0){
								while(i<portfolioArray.size()){
									
									if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) == 0){
										if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) > 0){
										    while(i<portfolioArray.size()){
												if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
													portfolioArray.add(i,port);
													return portfolioArray;
												}	
												i++;
										    }
										    portfolioArray.add(i,port);
											return portfolioArray;
										}
										if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) < 0){
											  while(i<portfolioArray.size()&& i>=0){
												  if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
														portfolioArray.add(i,port);
														return portfolioArray;
													}	
											    	i--;
											    }
											  portfolioArray.add(i,port);
												return portfolioArray;
										}
										if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
											portfolioArray.add(i, port);
										}	
									}
									if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) > 0){
										   while(i<portfolioArray.size()){
												if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) == 0){
													if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) > 0){
													    while(i<portfolioArray.size()){
															if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
																portfolioArray.add(i,port);
																return portfolioArray;
															}	
															i++;
													    }
													    portfolioArray.add(i,port);
														return portfolioArray;
													}
													if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) < 0){
														  while(i<portfolioArray.size() && i>=0){
															  if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
																	portfolioArray.add(i,port);
																	return portfolioArray;
																}	
														    	i--;
														    }
														  portfolioArray.add(i,port);
															return portfolioArray;
													}
													if(portfolioArray.get(i).getManagerFirstName().compareTo(port.getManagerFirstName()) == 0){
														portfolioArray.add(i, port);
													}	
												}	
												i++;
										    }	
										   	portfolioArray.add(i, port);
											return portfolioArray;
									}						
								if(portfolioArray.get(i).getManagerLastName().compareTo(port.getManagerLastName()) <0){
									portfolioArray.add(i,port);
									return portfolioArray;
								}
								i++;
								}
							}
							i++;
					    }	
					   	portfolioArray.add(i, port);
						return portfolioArray;
			}
		}	
		portfolioArray.add(port);
		return portfolioArray;
	}
	
	public static List<Portfolio> addPortfolioSortedByTotalValue(List<Portfolio> portfolioArray, Portfolio port){
		for(int i=0; i<portfolioArray.size(); i++){
			if(portfolioArray.size() == 0){
				portfolioArray.add(port);
				return portfolioArray;
			}
			if(portfolioArray.get(i).getTotalValue()==port.getTotalValue()){
				portfolioArray.add(i,port);
				return portfolioArray;
			}
			if(portfolioArray.get(i).getTotalValue()<port.getTotalValue()){
				portfolioArray.add(i,port);
				return portfolioArray;
			}
			if(portfolioArray.get(i).getTotalValue()>port.getTotalValue()){
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
				portfolioArray.add(i,port);
				return portfolioArray;
			}	
		}
		portfolioArray.add(port);
		return portfolioArray;
	}
	

}

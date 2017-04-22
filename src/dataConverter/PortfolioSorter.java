package dataConverter;

import java.util.ArrayList;
import java.util.List;

public interface PortfolioSorter {

	public static List<Portfolio> addPortfolioSortedByOwnerName(List<Portfolio> portfolioArray, Portfolio port){
	
		for(int i=0; i<portfolioArray.size(); i++){
			if(portfolioArray.isEmpty()){
				portfolioArray.add(port);
				return portfolioArray;
			}
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
//		for(int i=0; i<portfolioArray.size(); i++){
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

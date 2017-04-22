package dataConverter;

import java.util.List;

public interface PortfolioSorter {

	public static List<Portfolio> addPortfolioSortedByOwnerName(List<Portfolio> portfolioArray, Portfolio port){
	
		for(int i=0; i<portfolioArray.size(); i++){
			if(portfolioArray.size() == 0){
				portfolioArray.add(port);
				return portfolioArray;
			}
			if(portfolioArray.get(i).getOwnerLastName().compareTo(port.getOwnerLastName()) == 0){
				if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) > 0){
				    while(i<portfolioArray.size()){
						if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) == 0){
							portfolioArray.add(i,port);
							return portfolioArray;
						}	
						i++;
				    }
				    portfolioArray.add(i,port);
					return portfolioArray;
				}
				if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) < 0){
					  while(i<portfolioArray.size()&& i>=0){
						  if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) == 0){
								portfolioArray.add(i,port);
								return portfolioArray;
							}	
					    	i--;
					    }
					  portfolioArray.add(i,port);
						return portfolioArray;
				}
				if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) == 0){
					portfolioArray.add(i, port);
				}	
			}
			if(portfolioArray.get(i).getOwnerLastName().compareTo(port.getOwnerLastName()) > 0){
				   while(i<portfolioArray.size()){
						if(portfolioArray.get(i).getOwnerLastName().compareTo(port.getOwnerLastName()) == 0){
							if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) > 0){
							    while(i<portfolioArray.size()){
									if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) == 0){
										portfolioArray.add(i,port);
										return portfolioArray;
									}	
									i++;
							    }
							    portfolioArray.add(i,port);
								return portfolioArray;
							}
							if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) < 0){
								  while(i<portfolioArray.size()&& i>=0){
									  if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) == 0){
											portfolioArray.add(i,port);
											return portfolioArray;
										}	
								    	i--;
								    }
								  portfolioArray.add(i,port);
									return portfolioArray;
							}
							if(portfolioArray.get(i).getOwnerFirstName().compareTo(port.getOwnerFirstName()) == 0){
								portfolioArray.add(i, port);
							}	
						}	
						i++;
				    }	
				   	portfolioArray.add(i, port);
					return portfolioArray;
			}
		
		if(portfolioArray.get(i).getOwnerLastName().compareTo(port.getOwnerLastName()) <0){
			portfolioArray.add(i,port);
			return portfolioArray;
		}
		}
		return portfolioArray;
	}

	
	
	
	
	
	
	public static List<Portfolio> addPortfolioSortedByManagerTypeAndName(List<Portfolio> portfolioArray, Portfolio port){
		for(int i=0; i<portfolioArray.size(); i++){
			if(portfolioArray.size() == 0){
				portfolioArray.add(port);
				return portfolioArray;
			}
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
							i++;
					    }	
					   	portfolioArray.add(i, port);
						return portfolioArray;
			}
		}	
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
		return portfolioArray;
	}
}

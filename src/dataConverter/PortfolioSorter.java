package dataConverter;

import java.util.ArrayList;
import java.util.List;

public interface PortfolioSorter {

	public static List<Portfolio> addPortfolioSortedByOwnerName(List<Portfolio> portfolioArray, Portfolio port){
		for(int i=0; i<portfolioArray.size(); i++){
			
		}
		
		return portfolioArray;
	}

	public static List<Portfolio> addPortfolioSortedByManagerTypeAndName(List<Portfolio> portfolioArray, Portfolio port){
		for(int i=0; i<portfolioArray.size(); i++){
			
		}
		
		return portfolioArray;
	}
	public static List<Portfolio> addPortfolioSortedByTotalValue(List<Portfolio> portfolioArray, Portfolio port){
		for(int i=0; i<portfolioArray.size(); i++){
			
		}

		return portfolioArray;
	}
//	public static void insertionSort (List<Portfolio> portfolioArray()) {
//		 Portfolio tempPort;
//		 for (int i =1; i < portfolioArray.size() ; i ++) {
//			 tempPort = portfolioArray.get(i);
//		 	int j = i ;
//		//fix this comparison to change how it is sorted
//		 	while ( j > 0 && portfolioArray.get(j-1) > tempPort) {
//		 	portfolioArray.get(j) = portfolioArray.get(j-1);
//		 	j--;
//		 	}
//		 	portfolioArray.get(j) = tempPort ;
//		 }
//	}
	

}

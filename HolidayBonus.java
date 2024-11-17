public final class HolidayBonus {

    private static final double HIGH_BONUS = 5000.0;
    private static final double LOW_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            double total=0.0;
            for (int j=0; j<data[i].length;j++) {
            	if (data[i][j]<0) {
            		total+=0;
            	}
            	else if (data[i][j]==TwoDimRaggedArrayUtility.getHighestInColumn(data,j)) {
            		total+=HIGH_BONUS;
            	}
            	else if (data[i][j]==TwoDimRaggedArrayUtility.getLowestInColumn(data,j)) {
            		total+=LOW_BONUS;
            	}
            	else {
            		total+=OTHER_BONUS;
            	}
            }
            bonuses[i]=total;
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0;
        double[] bonuses = calculateHolidayBonus(data);
        for (int i = 0; i < bonuses.length; i++) {
            totalBonus += bonuses[i];
        }
        return totalBonus;
    }
}

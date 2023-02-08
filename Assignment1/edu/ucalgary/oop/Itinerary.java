package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/
//Name:Sukhreet Kaur Chahal
//UCID:30152950

public class Itinerary {
    private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return(value+"("+key+")"); //reference output
    }

    // Constructor
    public Itinerary(String[][] myTrips) {
        for(int i=0;i< myTrips.length;i++)
        {l 
            this.trips[i]=new Trip(myTrips[i]);
        }
    }

    // Getter
    public Trip[] getTrips() {
        return trips;
    }

    public String formatByArrival() {
        String arr[][][]=byDate();
        String stringOut="";
        int a=0;
        for (int i=0;i<3;i++)
        {
            int b=0;
            for(int j=0;j<12;j++)
            {
                int c=0;
                for(int k=0;k<20;k++)
                {
                    if(arr[a][b][c]!=null)
                    {
                        if(b==0)
                          {
                             if(a==1)
                               {
                                 stringOut+="\n";
                               }
                             a=1;
                             stringOut+=fmtString("Year",String.valueOf(2021+i));
                             b++;
                          }
                        if(c==0){
                            stringOut+="\n--"+fmtSyring("Month",String.valueOf(1+j));
                            c++;
                        }
                        stringOut+="\n----"+fmtString("Place",arr[i][j][k]);
                    }
                }     
            }     
        }
        return(stringOut);
                                             
    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
        String arr[][][] = new String[3][12][20];
    for(int i = 0; i < trips.length; i++)
    {
    if(trips[i] != null)
    {
    String date = trips[i].getArrival();
    int year = trips[i].getYear(date);
    int month = trips[i].getMonth(date);
    int occurance = 0;
    for (int y = 0; y < 3; y++)
    {
    for (int m = 0; m < 12; m++)
    {
    for (int o = 0; o < 20; o++)
    {
    if (arr[y][m][o] == null && y == year - 2021 && m == month - 1)
    {
    arr[y][m][o] = fmtString("City", trips[i].getCity()) + ", "
    + fmtString("Country", trips[i].getCountry());
    break;
    }
    }
    }
    }
    }
    }
    return(arr);
    }

}

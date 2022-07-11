/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 3         Summer 2021  *
 *                                                        *
 *  Class Name: TipCalculator                             *
 *                                                        *
 *  Developer(s):  Leonart Jaos                           *
 *                                                        *
 *  Purpose: TipCalculator is a class that contains membe-*
 *  rs that allow someone to calculate a tip from a base  *
 *  bill, and if there are more party members, the total  *
 *  bill may be split amongst a party. The members and the*
 *  methods that perform the calculation for the total bi-*
 *  ll and how it is split amongst a party.               *
 *                                                        *
 **********************************************************/ 


public class TipCalculator
{
  private double bill; // bill amount
  private int pct; // tip percentage
  private int pty; // party size
  
  // default constructor
  public TipCalculator()
  {
    bill = 0; // base bill total
    pct = 20; // percentage of tip total
    pty = 1; // number of members in a group
  }
  // constructor with arguments
  public TipCalculator(double bill, int pct, int pty)
  {
    if(bill >= 0 && pct >= 0 && pty >= 1)
    {
      this.bill = bill;
      this.pct = pct;
      this.pty = pty;
    }
    // default values given constructor values are invalid
    else 
    {
      this.bill = 0;
      this.pct = 20;
      this.pty = 1;      
    }
  }
  // setter for bill
  public void setBill(double bill)
  {
    this.bill = bill;
  }
  // getter for bill
  public double getBill()
  {
    return bill;
  }
  // setter for tip percentage
  public void setPct(int pct)
  {
    this.pct = pct;
  }
  // getter for tip percentage
  public int getPct()
  {
    return pct;
  }
  // setter for party size
  public void setPty(int pty)
  {
    this.pty = pty;
  }
  // getter for party size
  public int getPty()
  {
    return pty;
  }
  // method that computes and returns the total bill, tip included
  public double getTotalBill()
  {
    return ((bill * (pct + 100))/100);
  }
  // method that computes and returns the value of an equal share of the total bill
  public double getIndividualShare()
  {
    return (((bill * (pct + 100))/100)/pty);
  }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoesstore;

/**
 *
 * @author user
 */
public class Shoes {
    private int shoesId;
    private String shoesName;
    private int stock;


 public Shoes(int shoesId, String shoesName, int stock){
     this.shoesId = shoesId;
     this.shoesName = shoesName;
     this.stock = stock;
 }

 public int getShoesId() {
  return shoesId;
 }

 public String getShoesName() {
  return shoesName;
 }

 public int getStock() {
  return stock;
 }

 // Setter Methods 

 public void setShoesId(int shoesId) {
  this.shoesId = shoesId;
 } 
 public void setShoesName(String shoesName) {
  this.shoesName = shoesName;
 }

 public void setStock(int stock) {
  this.stock = stock;
 }
}

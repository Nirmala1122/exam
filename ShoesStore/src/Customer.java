
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.DriverManager;
import shoesstore.ShoesStore;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import shoesstore.Shoes;


public class Customer extends javax.swing.JFrame {
    final List<Shoes> shoeslist = new ArrayList<>();
    private Shoes selectedShoes;
    
    public Customer() {
        initComponents();
        shoesID.addItem("pilih id");
        readAllShoes();

    }
    
    private void readAllShoes(){
        try {
            String sqlQuery = "SELECT * FROM `shoes`";
            Connection conn = ShoesStore.configDB();
            PreparedStatement prepare = conn.prepareStatement(sqlQuery);
            ResultSet result = prepare.executeQuery();
            
            while(result.next()){
                System.out.println("error" + result.getString(2));
               shoesID.addItem(result.getString(1));
               shoeslist.add(new Shoes(
                       result.getInt(1),
result.getString(2), 
                       result.getInt(3)));
            }    
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Gagal mengambil data");
        }
    }
    private void tampilkan_data(){
    
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Sepatu");
        model.addColumn("Quantity");
        model.addColumn("Price");
        model.addColumn("SubTotal");
        
        try{
            int no = 1;
            String sql = "SELECT * FROM shoes";
            java.sql.Connection conn = (Connection)ShoesStore.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res =  stm.executeQuery(sql);
            
            while(res.next()){
               // model.addRow(new object[] {no++, res.getInt(1), res.getString(2), res.getString(3), res.)
            
            
            }
        
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    
     private void fillShoesIDComboBox() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ShoesStore.configDB();

            // Membuat query SQL
            String query = "SELECT Shoes_ID FROM Shoes";

            // Mempersiapkan statement
            statement = connection.prepareStatement(query);

            // Menjalankan query untuk mendapatkan data
            resultSet = statement.executeQuery();

            // Membersihkan combo box sebelum mengisi dengan data baru
            shoesID.removeAllItems();

            // Menambahkan data ke combo box
            while (resultSet.next()) {
                String shoesIDValue = resultSet.getString("Shoes_ID");
                shoesID.addItem(shoesIDValue);
            }

            // Menutup resultSet
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Menutup koneksi dan sumber daya terkait
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error closing ResultSet: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error closing PreparedStatement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing Connection: " + e.getMessage());
                }
            }
        }
    }

    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGrandTotal = new javax.swing.JTextField();
        txtSales_Date = new javax.swing.JTextField();
        txtCustomer_ID = new javax.swing.JTextField();
        txtCustomer_RedNo = new javax.swing.JTextField();
        txtViewCustomer_Name = new javax.swing.JTextField();
        txtSales_ID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        shoesID = new javax.swing.JComboBox<>();
        shoesName = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSales = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        ButtonView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shoes Store");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Shoes Store");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel2.setText("Purchase ID         :");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel3.setText(" Tanggal                  :");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel4.setText("Kode Vendor      :");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel5.setText("Vendor RefNo    :");

        txtGrandTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrandTotalActionPerformed(evt);
            }
        });

        txtSales_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSales_DateActionPerformed(evt);
            }
        });

        txtCustomer_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomer_IDActionPerformed(evt);
            }
        });

        txtViewCustomer_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewCustomer_NameActionPerformed(evt);
            }
        });

        txtSales_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSales_IDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("Shoes_ID");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText("Nama Sepatu");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText("Quantity");

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("Price");

        shoesID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoesIDActionPerformed(evt);
            }
        });

        shoesName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoesNameActionPerformed(evt);
            }
        });

        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton1.setText("Tambah Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton2.setText("Hapus Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText("Sales Detail");

        tableSales.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tableSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Sepatu", "Quantity", "Price", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(tableSales);

        jButton3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton3.setText("Simpan");

        jButton4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton4.setText("Keluar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        ButtonView.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        ButtonView.setText("View");
        ButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shoesID, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(shoesName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(87, 87, 87)
                                .addComponent(jLabel8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCustomer_RedNo, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSales_Date, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(txtSales_ID)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCustomer_ID))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ButtonView, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtViewCustomer_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(224, 224, 224)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSales_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSales_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCustomer_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonView, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtViewCustomer_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCustomer_RedNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shoesID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shoesName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(30, 30, 30)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSales_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSales_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSales_DateActionPerformed

    private void txtCustomer_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomer_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer_IDActionPerformed

    private void shoesIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoesIDActionPerformed
        if(!shoeslist.isEmpty()){
            System.out.println("error" + shoesID.getSelectedIndex());
            System.out.println("error" + shoeslist);
            selectedShoes = shoeslist.get(shoesID.getSelectedIndex());
            shoesName.setText(selectedShoes.getShoesName());
            
           // if(!tglPengembalian.getText().isEmpty() && countBetweenDateString(tglPeminjaman.getText(), tglPengembalian.getText()) > 0){
              //  int totalPrice = countBetweenDateString(tglPeminjaman.getText(), tglPengembalian.getText()) * selectedBook.getHarga();
               // Harga.setText(String.valueOf(totalPrice));
           // }
        }
     
    }//GEN-LAST:event_shoesIDActionPerformed

    private void shoesNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoesNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shoesNameActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    // Mendapatkan nilai dari fields seperti shoes_ID, shoes_name, quantity, dan price
    String shoes_ID = shoesID.getSelectedItem().toString();
    String shoes_Name = shoesName.getText();
    int txtquantity = Integer.parseInt(quantity.getText());
    double txtprice = Double.parseDouble(txtPrice.getText());
    
     // Menghitung subtotal
    double subtotal = txtquantity * txtprice;
    
    // Menyimpan data ke tabel "sales detail" menggunakan API atau metode yang sesuai
    saveSalesDetail(shoes_ID, shoes_Name, txtquantity, txtprice);
    addDataToTableContent(subtotal);

    calculateGrandTotal();
}

        private void addDataToTableContent(double subtotal){
        DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
        model.addRow(new Object[]{
            selectedShoes.getShoesId(),
            selectedShoes.getShoesName(),
            quantity.getText(),
            txtPrice.getText(),
            subtotal
        });
        }
        
        
    private void saveSalesDetail(String shoesID, String shoesName, int quantity, double price) {
    // Lakukan operasi penyimpanan ke tabel "sales detail" di sini, sesuai dengan metode yang Anda gunakan untuk menghubungkan ke basis data
    // Contoh: menggunakan JDBC untuk menyimpan data ke MySQL
    Connection connection = null;
    PreparedStatement statement = null;
    
    try {
        connection = ShoesStore.configDB();
        
        // Membuat query SQL
        String query = "INSERT INTO sales_detail (shoes_id, shoes_name, quantity, price) VALUES (?, ?, ?, ?)";
        
        // Mempersiapkan statement dengan parameter
        statement = connection.prepareStatement(query);
        statement.setString(1, shoesID);
        statement.setString(2, shoesName);
        statement.setInt(3, quantity);
        statement.setDouble(4, price);
        
        // Menjalankan query untuk menyimpan data
        statement.executeUpdate();
        
        // Menutup statement
        statement.close();
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        // Menutup koneksi dan sumber daya terkait
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error closing PreparedStatement: " + e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing Connection: " + e.getMessage());
            }
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         // Clear Form Button
        txtSales_ID.setText("");
        shoesID.setSelectedIndex(0);
        shoesName.setText("");
        txtPrice.setText("");
        quantity.setText("");

        DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
        model.setRowCount(0); // Clear the table

        calculateGrandTotal();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtSales_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSales_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSales_IDActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void ButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonViewActionPerformed
        txtViewCustomer_Name.setText("");
        if (!txtCustomer_ID.getText().isEmpty()){
           try{
               
                String sql = "SELECT * FROM `customer` WHERE Customer_ID =" + txtCustomer_ID.getText();
                Connection conn = ShoesStore.configDB();
                PreparedStatement prepare = conn.prepareStatement(sql);
                ResultSet result = prepare.executeQuery();
                
                if (!result.isBeforeFirst()){
                    JOptionPane.showMessageDialog(this, "Customer belum terdaftar");
                } else {
                    while (result.next()) {
                     txtViewCustomer_Name.setText(result.getString(2));
                    }
                }
                
           } catch(Exception e){
              System.out.println("Error :" + e.getMessage());  
           }
        }
    }

private String getCustomerName(String customerID) {
    // Menggunakan koneksi ke database dan melakukan query untuk mendapatkan Customer_Name
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String customerName = null;
    
    try {
        // Mendapatkan koneksi ke database
        connection = ShoesStore.configDB();
        
        // Membuat query SQL
        String query = "SELECT Customer_Name FROM Customer WHERE Customer_ID = ?";
        
        // Mempersiapkan statement dengan parameter
        statement = connection.prepareStatement(query);
        statement.setString(1, customerID);
        
        // Menjalankan query dan mendapatkan hasil
        resultSet = statement.executeQuery();
        
        // Memeriksa apakah hasil query mengandung data
        if (resultSet.next()) {
            // Mendapatkan Customer_Name dari hasil query
            customerName = resultSet.getString("Customer_Name");
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        // Menutup koneksi dan sumber daya terkait
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error closing PreparedStatement: " + e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing Connection: " + e.getMessage());
            }
        }
    }
    
    return customerName;
    }//GEN-LAST:event_ButtonViewActionPerformed

    private void txtViewCustomer_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewCustomer_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewCustomer_NameActionPerformed
     private void calculateGrandTotal() {
        DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
        int rowCount = model.getRowCount();
        double grandTotal = 0;

        for (int i = 0; i < rowCount; i++) {
            double subtotal = Double.parseDouble(model.getValueAt(i, 4).toString());
            grandTotal += subtotal;
        }

        txtGrandTotal.setText(String.valueOf(grandTotal));
    }
    
    private void txtGrandTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrandTotalActionPerformed
        // TODO add your handling code here:
        // Perform action when txtGrandTotal is clicked
        double grandTotal = Double.parseDouble(txtGrandTotal.getText());
        JOptionPane.showMessageDialog(this, "Grand Total: " + grandTotal);
    
    }//GEN-LAST:event_txtGrandTotalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
            Customer customer = new Customer();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonView;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField quantity;
    private javax.swing.JComboBox<String> shoesID;
    private javax.swing.JTextField shoesName;
    private javax.swing.JTable tableSales;
    private javax.swing.JTextField txtCustomer_ID;
    private javax.swing.JTextField txtCustomer_RedNo;
    private javax.swing.JTextField txtGrandTotal;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSales_Date;
    private javax.swing.JTextField txtSales_ID;
    private javax.swing.JTextField txtViewCustomer_Name;
    // End of variables declaration//GEN-END:variables
}

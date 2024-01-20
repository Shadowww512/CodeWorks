package labs.lab9;
import javax.naming.directory.InvalidAttributeValueException;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class myFrame extends JFrame {
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 750;
    private JTextField nameEntry, emailEntry,amountEntry;
    private JComboBox<String> storeLocations;
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox birdCheckBox;
    private JCheckBox fishCheckBox;
    private JCheckBox otherCheckBox;
    private JCheckBox[] checkboxs;
    private JTextArea notesEntry;

    private JButton deleteButton, saveButton, newButton;

    private DefaultListModel<String> customerList;
    private JList<String> customerList_display; //display the name of each customer
    
    private List<Customer> customers;

    private JPanel westPanel,eastPanel;
    
    private boolean isEditing = false;

    public myFrame(){
        setLayout(new GridLayout(1,2));
        makeWestPanel();
        makeEastPanel();
        add(westPanel);
        add(eastPanel);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Shifeng Hong 53124338");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void customerSelected(){
        String selected_customer = customerList_display.getSelectedValue();
        Customer selected = null;
        for (Customer c : customers){
            if(c.getName().equals(selected_customer)){
                selected = c;
            }
        }
        
        if (selected == null){
            return;
        }
        //load the entry
        nameEntry.setText(selected.getName());
        emailEntry.setText(selected.getEmail());
        amountEntry.setText(String.valueOf(selected.getAmount()));
        storeLocations.setSelectedItem(selected.getLocation());
        notesEntry.setText(selected.getNotes());
        int i = 0;
        //System.out.println(selected.getpets_selection());
        for ( char c : selected.getpets_selection().toCharArray()){
            if(c == '1'){
                checkboxs[i].setSelected(true);
            } else { 
                checkboxs[i].setSelected(false);
            }
            i++;
        }
    }
    public void makeCustomerList(){
        //make a customer list, bind with defauly list model and customers, and bind to listener
        customerList = new DefaultListModel<String>();
        customerList_display = new JList<String>(customerList);
        customers = new ArrayList<Customer>();
        class customerSelectListener implements ListSelectionListener{
            public void valueChanged(ListSelectionEvent e ){
                customerSelected();
            }
        }
        customerList_display.addListSelectionListener(new customerSelectListener());
    }
    public void deleteSelectedCustomer(){
        String selected_customer = customerList_display.getSelectedValue();
        if(selected_customer == null){
            //skip
        } else {
            customerList.removeElement(selected_customer);
            customers.removeIf(c -> c.getName().equals(selected_customer));
        }
    }
    
    public void makeDeleteButton(){
        deleteButton = new JButton("Delete");
        class deleteButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                deleteSelectedCustomer();
            }
        }
        deleteButton.addActionListener(new deleteButtonListener());
    }
    
    public void makeWestPanel(){
        westPanel = new JPanel(new GridLayout(2,1));
        makeCustomerList();
        makeDeleteButton();
        westPanel.add(customerList_display);
        westPanel.add(deleteButton);
    }

    public JPanel makeLabeledTextEntry(String label,JTextField t){
        JPanel x = new JPanel();
        x.add(new JLabel(label));
        x.add(t);
        return x;
    }

    public JPanel makeNotesEntry(){
        JPanel notesPanel = new JPanel();
        notesEntry = new JTextArea(5, 20);
        notesEntry.setEditable(true); // To make it non-editable
        notesEntry.setLineWrap(true); // Enable line wrapping
        notesEntry.setWrapStyleWord(true); // Wrap at word boundaries

        JScrollPane scrollPane = new JScrollPane(notesEntry);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//vertical scrolling only, because text wrapping is in place
        
        JLabel notesLabel = new JLabel("Notes: ");

        notesPanel.add(notesLabel);
        notesPanel.add(scrollPane);

        return notesPanel;
    }

    public JPanel makePetsPanel(){
        //this panel will contain a label and muliple check boxes
        JPanel petsPanel = new JPanel(); //default to flow layout
        JLabel petsLabel = new JLabel("Pets: ");
        dogCheckBox = new JCheckBox("Dog(s)");
        catCheckBox = new JCheckBox("Cat(s)");
        birdCheckBox = new JCheckBox("Bird(s)");
        fishCheckBox = new JCheckBox("Fish");
        otherCheckBox = new JCheckBox("Other");
        checkboxs = new JCheckBox[] {dogCheckBox,catCheckBox,birdCheckBox,fishCheckBox,otherCheckBox};
        petsPanel.add(petsLabel);
        petsPanel.add(dogCheckBox);
        petsPanel.add(catCheckBox);
        petsPanel.add(birdCheckBox);
        petsPanel.add(fishCheckBox);
        petsPanel.add(otherCheckBox);
        return petsPanel;
    }

    public JPanel makeLocationPanel(){
        JPanel locationPanel = new JPanel();
        String[] locations = {"Irvine", "Los Angeles", "Paris", "Shanghai", "New York", "London"};
        storeLocations = new JComboBox<String>(locations);
        JLabel locationLabel = new JLabel("Home Store Location: ");
        locationPanel.add(locationLabel);
        locationPanel.add(storeLocations);
        return locationPanel;
    }

    public void saveCustomer() throws InvalidAttributeValueException{
        String selecting = customerList_display.getSelectedValue();
        String name = nameEntry.getText();
        String email = emailEntry.getText();
        String location = (String)storeLocations.getSelectedItem();
        String notes = notesEntry.getText();
        Double amount = 0.0;

        if(selecting != null){ //if is editing
            isEditing = true;
        } else if (customerList.contains(name)){ //if not editing, but name enter exist in the database, throw error to prevent duplicate
            throw new InvalidAttributeValueException();
        }

        //verify input
        if (name.equals("") || email.equals("")){ //if name or email left blank
            throw new InvalidAttributeValueException();
        }

        if (customerList.contains(name) && !isEditing){//if repeated information and is not currently selecting (non-editing)
            throw new InvalidAttributeValueException();
        }

        try{
            amount = Double.parseDouble(amountEntry.getText());
        } catch (Exception e){//if invalid double number
            throw new InvalidAttributeValueException();
        }

        if(amount < 0){//if negative double number
            throw new InvalidAttributeValueException();
        }

        String pets_selection = ""; //1 represent selected, 0 represent not selected
        for (JCheckBox box : checkboxs){
            pets_selection += box.isSelected()? 1 : 0;
        }

        //all valid input
        if(isEditing){ //if is editing
            //is editing current one, remove the original one
            customers.removeIf(c -> c.getName().equals(selecting));
        }
        Customer new_customer = new Customer(name,email,pets_selection,amount,location,notes);
        System.out.println(new_customer);
        customers.add(new_customer); //add in the new one, edited
        customerList.removeAllElements();
        Collections.sort(customers);
        //refresh every time new entry is inserted, ineffienct but worked
        for (Customer c : customers){
            customerList.addElement(c.getName());
        }
    }
    public void makeSaveButton(){
        saveButton = new JButton("Save Customer");
        class saveButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                    saveCustomer();
                    JOptionPane.showMessageDialog(eastPanel, "Customer saved!");
                    //System.out.println("Customer saved!");
                } catch (Exception exc){
                    System.out.println(exc.getMessage());
                    JOptionPane.showMessageDialog(eastPanel, "Invalid Input!");
                    //System.out.println("Invalid Input!");
                }
            }
        }
        saveButton.addActionListener(new saveButtonListener());
    }

    public void startNewCustomer(){
        //erase all entry
        nameEntry.setText("");
        emailEntry.setText("");
        for(JCheckBox box : checkboxs){
            box.setSelected(false);
        }
        amountEntry.setText("0.0");
        storeLocations.setSelectedItem("Irvine");
        notesEntry.setText("");
        //System.out.println("Erased all entry !");
    }
    public void makeNewButton(){
        newButton = new JButton("New Customer");
        class newButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                startNewCustomer();
            }
        }
        newButton.addActionListener(new newButtonListener());
    }
    public void makeEastPanel(){
        nameEntry = new JTextField(10);
        JPanel namePanel = makeLabeledTextEntry("Name: ", nameEntry);

        emailEntry = new JTextField(10);
        JPanel emailPanel = makeLabeledTextEntry("Email: ", emailEntry);

        amountEntry = new JTextField(10); //default to 0.0
            amountEntry.setText("0.0");
        JPanel amountPanel = makeLabeledTextEntry("Total Amount Spent: ", amountEntry);
        JPanel notesPanel = makeNotesEntry(); //this construct the scrollable text area and return a JPanel
        JPanel petsPanel = makePetsPanel();
        JPanel locationPanel = makeLocationPanel();

        makeSaveButton();
        makeNewButton();
        JPanel buttonsPanel = new JPanel(); //flow layout
        buttonsPanel.add(saveButton);
        buttonsPanel.add(newButton);

        eastPanel = new JPanel(new GridLayout(7,1));
        eastPanel.add(namePanel);
        eastPanel.add(emailPanel);
        eastPanel.add(petsPanel);
        eastPanel.add(amountPanel);
        eastPanel.add(locationPanel);
        eastPanel.add(notesPanel);
        eastPanel.add(buttonsPanel);
    }
}

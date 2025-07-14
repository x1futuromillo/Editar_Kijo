package Diferido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.text.BadLocationException;

public class AutoCompleteComboBox extends JComboBox {
   public int caretPos = 0;
   public JTextField inputField = null;
   public int selectIndex = -1;
   public String selectItem = "";

   public AutoCompleteComboBox(Object[] elements) {
      super(elements);
      this.setEditor(new BasicComboBoxEditor());
      this.setEditable(true);
   }

   public void setSelectedIndex(int index) {
      super.setSelectedIndex(index);
      this.inputField.setText(this.getItemAt(index).toString());
      this.inputField.setSelectionEnd(this.caretPos + this.inputField.getText().length());
      this.inputField.moveCaretPosition(this.caretPos);
   }

   public AutoCompleteComboBox getCombobox() {
      return this;
   }

   public void setEditor(ComboBoxEditor editor) {
      super.setEditor(editor);
      if (editor.getEditorComponent() instanceof JTextField) {
         this.inputField = (JTextField)editor.getEditorComponent();
         this.getCombobox().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               AutoCompleteComboBox.this.selectIndex = AutoCompleteComboBox.this.getSelectedIndex();
               AutoCompleteComboBox.this.selectItem = AutoCompleteComboBox.this.getSelectedItem().toString();
               System.setProperty("selectIndex", String.valueOf(AutoCompleteComboBox.this.selectIndex));
               System.setProperty("selectItem", AutoCompleteComboBox.this.selectItem);
            }
         });
         this.inputField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
               super.keyTyped(e);
               char key = e.getKeyChar();
               if ((key < '0' || key > '9') && key != '\b') {
                  e.consume();
               }

            }

            public void keyReleased(KeyEvent ev) {
               char key = ev.getKeyChar();
               if (Character.isLetterOrDigit(key) || Character.isSpaceChar(key)) {
                  AutoCompleteComboBox.this.getCombobox().showPopup();
                  AutoCompleteComboBox.this.caretPos = AutoCompleteComboBox.this.inputField.getCaretPosition();
                  String text = "";

                  try {
                     text = AutoCompleteComboBox.this.inputField.getText(0, AutoCompleteComboBox.this.caretPos);
                  } catch (BadLocationException var6) {
                     var6.printStackTrace();
                  }

                  for(int i = 0; i < AutoCompleteComboBox.this.getItemCount(); ++i) {
                     String element = (String)AutoCompleteComboBox.this.getItemAt(i);
                     if (element.startsWith(text)) {
                        AutoCompleteComboBox.this.setSelectedIndex(i);
                        return;
                     }
                  }

               }
            }
         });
      }

   }

   public int Index() {
      return this.selectIndex;
   }

   public String Item() {
      return this.selectItem;
   }
}

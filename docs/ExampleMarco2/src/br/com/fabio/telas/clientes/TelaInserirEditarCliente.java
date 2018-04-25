package br.com.fabio.telas.clientes;

import br.com.fabio.model.clientes.Cliente;
import br.com.fabio.servico.ServicoCliente;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Tela para cadastro de cliente
 */
public class TelaInserirEditarCliente extends javax.swing.JInternalFrame {

    //Indica se a janela de cadastro está em modo de inserção ou de edição
    private boolean modoEdicao = false;

    //Indica o cliente em edição
    private Cliente cliente = null;

    //Construtor e inicialização de componentes
    public TelaInserirEditarCliente() {
        initComponents();
    }

    //Código gerado do GUI Builder
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSobrenome = new javax.swing.JLabel();
        txtSobrenome = new javax.swing.JTextField();
        lblDtNasc = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        lblGenero = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtFmtDtNasc = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastrar Cliente");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        lblNome.setText("Nome: ");

        lblSobrenome.setText("Sobrenome: ");

        lblDtNasc.setText("Data Nasc:");

        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Feminino", "Masculino" }));

        lblGenero.setText("Gênero: ");

        btnCancelar.setText("Fechar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtFmtDtNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSobrenome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDtNasc, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtSobrenome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFmtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblGenero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboGenero, 0, 140, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSobrenome)
                    .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtNasc)
                    .addComponent(lblGenero)
                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFmtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Listener do botão cancelar
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        //Fecha a janela
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    //Listener do botão salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        //Cria uma nova instância do cliente e a popula com 
        //seus valores dos campos da tela caso não esteja no modo de edição
        //Caso esteja no modo de edição, verifica se o cliente foi fornecido
        //e atualiza seus valores
        if (!modoEdicao) {
            
            cliente = new Cliente();
            
        } else if (cliente == null) {
            
            //Exibe mensagem de erro para o usuário caso a tela tenha sido
            //aberta para edição, mas não haja cliente informado para tanto
            JOptionPane.showMessageDialog(rootPane,
                    "Não foi pré-selecionado um cliente para salvar suas"
                    + " alterações",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
            
        }

        //Para obter o valor digitado dentro de caixas de texto, basta utilizar
        //o método getText()
        cliente.setNome(txtNome.getText());
        cliente.setSobrenome(txtSobrenome.getText());

        //A data de nascimento está num campo formatado. Neste caso, não
        //utilizamos o getText(), mas sim o getValue(). Este método retorna
        //o valor do campo convertido para o tipo de dado adequado, configurado
        //na propriedade "formater factory" do componente. No entanto, o
        //getValue() retorna um tipo de dado genérico. É necessário realizar o
        //"casting" para transformar este tipo de dado em "Date" (ou qualquer
        //outro tipo de dado, como Double, Boolean, Integer e etc) para daí
        //conseguir atribuir este valor ao modelo (a data no modelo é do tipo
        //"Date" e este tipo deve ser respeitado
        Date dataConvertida = (Date) txtFmtDtNasc.getValue();
        cliente.setDataNascimento(dataConvertida);

        //Para obter o valor selecionado de combos, basta utiliza o método
        //getSelectedItem()
        cliente.setGenero((String) comboGenero.getSelectedItem());

        //Dependendo se está no modo edição ou não, chama o elemento do serviço
        //correto para inserir ou atualizar os dados do cliente
        String resposta = null;
        if (!modoEdicao) {
            
            resposta = ServicoCliente.cadastrarCliente(cliente);
            
        } else {
            
            resposta = ServicoCliente.atualizarCliente(cliente);
            
        }

        //Verifica a resposta de execução do serviço
        if (resposta == null) {

            //Se a resposta é nula, o cliente foi inserido/alterado com sucesso
            //Se não estiver no modo de edição, exibe uma mensagem de sucesso
            //para o usuário. Se estiver no modo de edição, fecha a janela
            if (!modoEdicao) {
                
                JOptionPane.showMessageDialog(rootPane,
                        "Cliente inserido com sucesso",
                        "Cadastro efetuado",
                        JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                
                this.dispose();
                
            }

            //Limpa os campos da tela após realizar a inserção
            //Para limpar campos de texto, basta atribui "" a estes, através do
            //método setText("")
            txtNome.setText("");
            txtSobrenome.setText("");

            //Em campos formatados, é preciso limpar o texto, assim como em
            //campos comuns, mas também é necessário limpar o valor. Caso
            //isto não seja feito, o vampo voltará ao último valor válido
            //caso receba e perca foco sem que um novo valor válido seja
            //digitado
            txtFmtDtNasc.setText("");
            txtFmtDtNasc.setValue(null);

            //Para reiniciar os combos no valor padrão, basta configurar o
            //índice do item selecionado como "0"
            comboGenero.setSelectedIndex(0);

            //Limpa o cliente em edição da tela
            cliente = null;
            
        } else {

            //Exibe mensagens de erro para o usuário
            JOptionPane.showMessageDialog(rootPane, resposta,
                    "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    //Método acionado quando o frame é aberto
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
        //Verifica se está no modo de edição e há um cliente para edição
        //informado
        if (modoEdicao && cliente != null) {

            //Para atribuir valores para campos de texto, utilizamos o
            //método setText(valor_a_ser_atribuído)
            txtNome.setText(cliente.getNome());
            txtSobrenome.setText(cliente.getSobrenome());

            //Em campos formatados, para atribuir valores, utilizamos o
            //método setValue(valor_a_ser_atribuído)
            txtFmtDtNasc.setValue(cliente.getDataNascimento());

            //Para atribuir valores a combos, é necessário percorre os valores
            //até localizar o índice que possua o valor a ser atribuído
            //e configurar este índice índice do item selecionado
            for (int i = 0; i < comboGenero.getItemCount(); i++) {
                
                //Se localizou o item do combo com o valor desejado,
                //configura o índice do combo como o índice localizado
                if (comboGenero.getItemAt(i).equals(cliente.getGenero())) {
                    
                    comboGenero.setSelectedIndex(i);
                    break;
                    
                }
                
            }
        }
    }//GEN-LAST:event_formInternalFrameOpened

    //Permite verificar se a tela está no modo de edição
    public boolean isModoEdicao() {
        return modoEdicao;
    }

    //Permite configurar a tela como modo edição
    public void setModoEdicao(boolean modoEdicao) {
        this.modoEdicao = modoEdicao;
    }

    //Permite obter o cliente configurado para edição
    public Cliente getCliente() {
        return cliente;
    }

    //Permite configurar um cliente para edição
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JLabel lblDtNasc;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSobrenome;
    private javax.swing.JFormattedTextField txtFmtDtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables
}

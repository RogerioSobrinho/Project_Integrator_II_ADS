package br.com.fabio.telas.clientes;

import br.com.fabio.model.clientes.Cliente;
import br.com.fabio.servico.ServicoCliente;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//Tela de consulta de clientes
public class TelaConsultarClientes extends javax.swing.JInternalFrame {

    //Instância da tela de criação/edição de clientes
    TelaInserirEditarCliente telaInserirEditarCliente =
            new TelaInserirEditarCliente();

    //Construtor e inicialização de componentes
    public TelaConsultarClientes() {
        initComponents();
    }

    //Código gerado do GUI Builder
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPesquisa = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        tblResultados = new javax.swing.JScrollPane();
        tabelaResultados = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Clientes");

        lblPesquisa.setText("Pesquisar:");

        tabelaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Sobrenome", "Data de Nascimento", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaResultados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaResultadosMouseClicked(evt);
            }
        });
        tblResultados.setViewportView(tabelaResultados);

        btnCancelar.setText("Fechar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tblResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisa)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Listener do botão de pesquisa
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
        //Chama o método de pesquisa
        pesquisar();
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    //Trata os cliques na tabela de resultados de pesquisa de clientes
    private void tabelaResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaResultadosMouseClicked
        //Verifica se o clique é um clique duplo       
        if (evt.getClickCount() == 2) {
            
            //Chama o método de alteração
            alterar();
            
        }
    }//GEN-LAST:event_tabelaResultadosMouseClicked

    //Trata o comportamento de exclusão do botão respectivo
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        //Verifica se há itens selecionados para exclusão na tabela visual.
        //Caso negativo, ignora o comando
        if (tabelaResultados.getSelectedRow() >= 0) {

            //Obtém a linha do item selecionado na tabela visual
            final int row = tabelaResultados.getSelectedRow();

            //Obtém o nome do cliente da linha indicada para exibição
            //de mensagem de confirmação de exclusão utilizando seu nome
            String nome = (String) tabelaResultados.getValueAt(row, 1);

            //Mostra o diálogo de confirmação de exclusão
            int respostaConfirmacao = JOptionPane.showConfirmDialog(rootPane,
                    "Excluir o cliente \"" + nome + "\"?",
                    "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

            //Se o valor de respostaConfirmacao for "Sim" para a exclusão,
            //significa que o usuário confirmou a operação
            if (respostaConfirmacao == JOptionPane.YES_OPTION) {

                //Obtém o ID do cliente da tabela do componente visual
                Integer id = (Integer) tabelaResultados.getValueAt(row, 0);

                //Solicita ao serviço a exclusão do cliente com o ID
                String respostaServico = ServicoCliente.excluirCliente(id);

                if (respostaServico == null) {
                    
                    //Se a resposta for nula, significa que o serviço conseguiu
                    //executar suas operações sem problemas, então, realiza a
                    //pesquisa novamente para exibir os dados modificados
                    pesquisar();
                    
                } else {
                    
                    //Se a resposta não for null, ocorreu um erro no serviço
                    //Exibe a mensagem de erro ao usuário
                    JOptionPane.showMessageDialog(rootPane, respostaServico,
                            "Falha na Exclusão", JOptionPane.ERROR_MESSAGE);
                    
                }

            }
            
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    //Listener do botão cancelar
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    //Trata o clique no botão de alteração
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void pesquisar() {

        //Realiza a pesquisa de clientes com o valor da caixa de pesquisa
        List<Cliente> resultado = ServicoCliente.
                procurarCliente(txtPesquisa.getText());

        //Obtém o elemento representante do conteúdo da tabela visual na tela
        DefaultTableModel model
                = (DefaultTableModel) tabelaResultados.getModel();

        //Indica que a tabela deve excluir todos seus elementos
        //Isto limpará a lista, mesmo que a pesquisa não tenha sucesso
        //(afinal, o botão de pesquisa foi clicado, a pesquisa anterior
        //não deve continuar sendo exibida)
        model.setRowCount(0);

        //Verifica se há resultados. Apenas atualiza o componente visual de
        //tabela com linhas de resultado caso haja resultados
        if (resultado != null && resultado.size() > 0) {

            //Percorre a lista de resultados e os adiciona na tabela
            for (int i = 0; i < resultado.size(); i++) {

                //Obtém cada item da lista de resultados
                Cliente cli = resultado.get(i);

                //Se há um cliente válido nesta posição da lista de resultados,
                //o adiciona na tabela
                if (cli != null) {

                    //Cria uma linha da tabela, que nada mais é que um array
                    //onde cada posição do array é uma coluna da linha da tabela
                    Object[] row = new Object[5];

                    //Popula cada coluna com os valores correspondentes daquele
                    //cliente (oriundo da posição da lista de resultados)
                    //O array das colunas precisa ser populado NA MESMA ORDEM
                    //da tabela visual do Swing, caso contrário poderão ocorrer
                    //erros ou dados ficarão em colunas inválidas ou sem
                    //correspondência
                    row[0] = cli.getId();
                    row[1] = cli.getNome();
                    row[2] = cli.getSobrenome();
                    row[3] = cli.getDataNascimento();
                    row[4] = cli.getGenero();

                    //Adiciona a linha na tabela
                    model.addRow(row);
                    
                }
                
            }

        } else {

            //Caso a pesquisa não tenha retornado resultados, exibe uma mensagem
            //de erro ao usuário
            JOptionPane.showMessageDialog(rootPane,
                    "Não há clientes para exibição",
                    "Não há dados",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    private void alterar() {

        //Obtém a linha selecionada da tabela visual de resultados
        int row = tabelaResultados.getSelectedRow();

        //Obtém o valor do ID da coluna "ID" da tabela de resultados
        Integer id = (Integer) tabelaResultados.getValueAt(row, 0);

        //Com o ID do usuário obtido da coluna da tabela visual,
        //chama o serviço de cliente para obter o cliente com dados
        //atualizados do mock
        Cliente cliente = ServicoCliente.obterCliente(id);

        //Verifica se o cliente que deve ser editado realmente existe        
        if (cliente != null) {

            //Se a tela de edição já está aberta, a fecha
            telaInserirEditarCliente.dispose();

            //Cria uma nova instância da tela de edição
            telaInserirEditarCliente = new TelaInserirEditarCliente();

            //Configura o cliente selecionado como elemento a
            //ser editado quando a tela de edição abrir
            telaInserirEditarCliente.setCliente(cliente);

            //Configura a tela de cadastro/edição como sendo uma tela de edição
            telaInserirEditarCliente.setModoEdicao(true);

            //Configura o título da janela de edição como sendo o nome 
            //e o sobrenome do cliente em edição
            telaInserirEditarCliente.setTitle(cliente.getNome()
                    + " " + cliente.getSobrenome());

            //Para exibir a tela, é necessário adicioná-la ao
            //componente de desktop, o "pai" da janela corrente
            //(APENAS PARA APLICAÇÕES DO TIPO DESKTOP)
            this.getParent().add(telaInserirEditarCliente);

            //Solicita que a tela abra no centro do desktop
            this.openFrameInCenter(telaInserirEditarCliente);

            //Solicita que a janela de edição venha "para frente" das demais
            //janelas
            telaInserirEditarCliente.toFront();

        }
        //Se o cliente que deve-se abrir para edição não existir na fonte de
        //dados, exibe uma mensagem de erro
        else {

            //Informa ao usuário que não foi possível abrir o cliente para
            //edição
            JOptionPane.showMessageDialog(rootPane, "Não foi possível localizar"
                    + " este cliente para edição",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
        }

    }

    //Abre um internal frame centralizado na tela
    public void openFrameInCenter(JInternalFrame jif) {

        //Obtém o tamanho do desktop        
        Dimension desktopSize = this.getParent().getSize();

        //Obtém o tamanho da janela interna a ser aberta no desktop
        Dimension jInternalFrameSize = jif.getSize();

        //Calcula o centro do desktop com base em seu tamanho e no tamanho
        //da janela a ser aberta no centro
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;

        //Configura a posição da janela calculada        
        jif.setLocation(width, height);

        //Solicita que a janela seja eixbida ao usuário
        jif.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JTable tabelaResultados;
    private javax.swing.JScrollPane tblResultados;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}

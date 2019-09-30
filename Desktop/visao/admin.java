package visao;

import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.bean.autoridade;
import modelo.bean.camiao;
import modelo.bean.comboio;
import modelo.bean.mercadoria;
import modelo.bean.navio;
import modelo.bean.noticia;
import modelo.bean.responsavel;
import modelo.bean.usuario;
import modelo.dao.autoridadedao;
import modelo.dao.camiaodao;
import modelo.dao.comboiodao;
import modelo.dao.mercadoriadao;
import modelo.dao.naviodao;
import modelo.dao.noticiadao;
import modelo.dao.responsaveldao;
import modelo.dao.usuariodao;

/**
 *
 * @author victor tesoura jr
 */
public final class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();

        txtcodigonoticia.setDocument(new numero());
        txtnupautoridade.setDocument(new numero());
        txttelefoneautoridade.setDocument(new numero());
        txtnupnavio.setDocument(new numero());
        txtnupresponsavel.setDocument(new numero());
        txtcodigocaminho.setDocument(new numero());
        txteditarresponsavelcaminho.setDocument(new numero());
        txtcodigoatracado.setDocument(new numero());
        txteditarresponsavelatracado.setDocument(new numero());
        txtcodigoarmazem.setDocument(new numero());
        txteditarresponsavelarmazem.setDocument(new numero());
        txtcodigodespachada.setDocument(new numero());;
        txtcodigoapreendida.setDocument(new numero());
        txtnupcomboio.setDocument(new numero());
        txtnupcamiao.setDocument(new numero());
        txtnupusuario.setDocument(new numero());
        txtsenhausuario.setDocument(new limite(33));

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        setExtendedState(MAXIMIZED_BOTH);
        btnfechar.setVisible(false);

        visualizarnoticia();
        visualizarautoridade();
        visualizarnavio();
        visualizarresponsavel();
        visualizarcaminho();
        visualizaratracado();
        visualizararmazem();
        visualizardespachada();
        visualizarapreendida();
        visualizarcomboio();
        visualizarcamiao();
        visualizarusuario();
        visualizarcontrole();

        autoridadedao dao = new autoridadedao();
        dao.usuario().forEach((u) -> {
            cbonupusuario.addItem(u + "");
        });
    }

    public void visualizarnoticia() {
        DefaultTableModel modelonoticia = (DefaultTableModel) jTablenoticia.getModel();
        modelonoticia.setNumRows(0);
        noticiadao ndao = new noticiadao();
        ndao.visualizar().forEach((n) -> {
            modelonoticia.addRow(new Object[]{
                n.getCodigo(),
                n.getTitulo(),
                n.getDescricao(),
                n.getEscritor()
            });
        });
    }

    public void limparnoticia() {
        txtcodigonoticia.setText("");
        txttitulonoticia.setText("");
        txtdescricaonoticia.setText("");
        visualizarnoticia();
    }
    
    public void procurarnoticia(int codigo) {
        DefaultTableModel modelonoticia = (DefaultTableModel) jTablenoticia.getModel();
        modelonoticia.setNumRows(0);
        noticiadao ndao = new noticiadao();
        ndao.procurar(codigo).forEach((n) -> {
            modelonoticia.addRow(new Object[]{
                n.getCodigo(),
                n.getTitulo(),
                n.getDescricao(),
                n.getEscritor()
            });
        });
    }

    public void procurarusuario(int codigo) {
        DefaultTableModel modelousuario = (DefaultTableModel) jTableusuario.getModel();
        modelousuario.setNumRows(0);
        usuariodao udao = new usuariodao();
        udao.procurar(codigo).forEach((u) -> {
            modelousuario.addRow(new Object[]{
                u.getCodigo(),
                u.gettipo(),
            });
        });
    }

    public void visualizarusuario() {
        DefaultTableModel modelousuario = (DefaultTableModel) jTableusuario.getModel();
        modelousuario.setNumRows(0);
        usuariodao udao = new usuariodao();
        udao.visualizarusuario().forEach((u) -> {
            modelousuario.addRow(new Object[]{
                u.getCodigo(),
                u.gettipo(),});
        });
    }

    public void visualizarcontrole() {
        DefaultTableModel modelocontrole = (DefaultTableModel) jTablecontrole.getModel();
        modelocontrole.setNumRows(0);
        usuariodao udao = new usuariodao();
        udao.visualizarcontrole().forEach((u) -> {
            modelocontrole.addRow(new Object[]{
                u.getCodigo(),
                u.getsenha(),});
        });
    }

    public void limparusuario() {
        txtnupusuario.setText("");
        txtsenhausuario.setText("");
        visualizarusuario();
        visualizarcontrole();
    }

    

    public void limparautoridade() {
        txtnupautoridade.setText("");
        txtnomeautoridade.setText("");
        txttelefoneautoridade.setText("");
        txtemailautoridade.setText("");
        txtenderecoautoridade.setText("");
        visualizarautoridade();
    }

    public void visualizarautoridade() {
        DefaultTableModel modeloautoridade = (DefaultTableModel) jTableautoridade.getModel();
        modeloautoridade.setNumRows(0);
        autoridadedao adao = new autoridadedao();
        adao.visualizar().forEach((a) -> {
            modeloautoridade.addRow(new Object[]{
                a.getCodigo(),
                a.getNome(),
                a.getTelefone(),
                a.getEmail(),
                a.getEndereco(),
                a.getCargo()
            });
        });
    }

    public void procurarautoridade(int codigo) {
        DefaultTableModel modeloautoridade = (DefaultTableModel) jTableautoridade.getModel();
        modeloautoridade.setNumRows(0);
        autoridadedao adao = new autoridadedao();
        adao.procurar(codigo).forEach((a) -> {
            modeloautoridade.addRow(new Object[]{
                a.getCodigo(),
                a.getNome(),
                a.getTelefone(),
                a.getEmail(),
                a.getEndereco(),
                a.getCargo()
            });
        });
    }

    public void limparnavio() {
        txtnupnavio.setText("");
        visualizarnavio();
    }

    public void visualizarnavio() {

        DefaultTableModel modelonavio = (DefaultTableModel) jTablenavio.getModel();
        modelonavio.setNumRows(0);
        naviodao nadao = new naviodao();
        nadao.visualizar().forEach((na) -> {
            modelonavio.addRow(new Object[]{
                na.getCodigo(),
                na.getMatricula(),
                na.getNome(),
                na.getTelefone(),
                na.getEmail(),
                na.getTipo(),
                na.getPais(),
                na.getPassageiros(),
                na.getChegada(),
                na.getPartida()
            });
        });
    }

    public void procurarnavio(int codigo) {
        DefaultTableModel modelonavio = (DefaultTableModel) jTablenavio.getModel();
        modelonavio.setNumRows(0);
        naviodao nadao = new naviodao();
        nadao.procurar(codigo).forEach((na) -> {
            modelonavio.addRow(new Object[]{
                na.getCodigo(),
                na.getMatricula(),
                na.getNome(),
                na.getTelefone(),
                na.getEmail(),
                na.getTipo(),
                na.getPais(),
                na.getPassageiros(),
                na.getChegada(),
                na.getPartida()
            });
        });
    }

    public void limparresponsavel() {
        txtnupresponsavel.setText("");
        visualizarresponsavel();
    }

    public void visualizarresponsavel() {

        DefaultTableModel modeloresponsavel = (DefaultTableModel) jTableresponsavel.getModel();
        modeloresponsavel.setNumRows(0);
        responsaveldao rdao = new responsaveldao();
        rdao.visualizar().forEach((r) -> {
            modeloresponsavel.addRow(new Object[]{
                r.getCodigo(),
                r.getNome(),
                r.getTelefone(),
                r.getEmail(),
                r.getEndereco()
            });
        });
    }

    public void procurarresponsavel(int codigo) {
        DefaultTableModel modeloresponsavel = (DefaultTableModel) jTableresponsavel.getModel();
        modeloresponsavel.setNumRows(0);
        responsaveldao rdao = new responsaveldao();
        rdao.procurar(codigo).forEach((r) -> {
            modeloresponsavel.addRow(new Object[]{
                r.getCodigo(),
                r.getNome(),
                r.getTelefone(),
                r.getEmail(),
                r.getEndereco()
            });
        });
    }

    public void limparcamiao() {
        txtnupcamiao.setText("");
        visualizarcamiao();
    }

    public void visualizarcamiao() {

        DefaultTableModel modelocamiao = (DefaultTableModel) jTablecamiao.getModel();
        modelocamiao.setNumRows(0);
        camiaodao cmdao = new camiaodao();
        cmdao.visualizar().forEach((cm) -> {
            modelocamiao.addRow(new Object[]{
                cm.getCodigo(),
                cm.getMatricula(),
                cm.getEmpresa(),
                cm.getTelefone(),
                cm.getEmail(),
                cm.getTipo(),
                cm.getPais(),
                cm.getPassageiros(),
                cm.getChegada()
            });
        });
    }

    public void procurarcamiao(int codigo) {
        DefaultTableModel modelocamiao = (DefaultTableModel) jTablecamiao.getModel();
        modelocamiao.setNumRows(0);
        camiaodao cmdao = new camiaodao();
        cmdao.procurar(codigo).forEach((cm) -> {
            modelocamiao.addRow(new Object[]{
                cm.getCodigo(),
                cm.getMatricula(),
                cm.getEmpresa(),
                cm.getTelefone(),
                cm.getEmail(),
                cm.getTipo(),
                cm.getPais(),
                cm.getPassageiros(),
                cm.getChegada()
            });
        });
    }

    public void limparcomboio() {
        txtnupcomboio.setText("");
        visualizarcomboio();
    }

    public void visualizarcomboio() {

        DefaultTableModel modelocomboio = (DefaultTableModel) jTablecomboio.getModel();
        modelocomboio.setNumRows(0);
        comboiodao cbdao = new comboiodao();
        cbdao.visualizar().forEach((cm) -> {
            modelocomboio.addRow(new Object[]{
                cm.getCodigo(),
                cm.getMatricula(),
                cm.getEmpresa(),
                cm.getTelefone(),
                cm.getEmail(),
                cm.getTipo(),
                cm.getPais(),
                cm.getPassageiros(),
                cm.getChegada(),
                cm.getPartida()
            });
        });
    }

    public void procurarcomboio(int codigo) {
        DefaultTableModel modelocomboio = (DefaultTableModel) jTablecomboio.getModel();
        modelocomboio.setNumRows(0);
        comboiodao cmdao = new comboiodao();
        cmdao.procurar(codigo).forEach((cm) -> {
            modelocomboio.addRow(new Object[]{
                cm.getCodigo(),
                cm.getMatricula(),
                cm.getEmpresa(),
                cm.getTelefone(),
                cm.getEmail(),
                cm.getTipo(),
                cm.getPais(),
                cm.getPassageiros(),
                cm.getChegada(),
                cm.getPartida()
            });
        });
    }

    public void limparcaminho() {
        txtcodigocaminho.setText("");
        txteditarresponsavelcaminho.setText("");
        visualizarcaminho();
    }

    public void visualizarcaminho() {

        DefaultTableModel modelocaminho = (DefaultTableModel) jTablecaminho.getModel();
        modelocaminho.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.visualizarcaminho().forEach((mr) -> {
            modelocaminho.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel()
            });
        });
    }

    public void procurarcaminho(int codigo) {
        DefaultTableModel modelocaminho = (DefaultTableModel) jTablecaminho.getModel();
        modelocaminho.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.procurarcaminho(codigo).forEach((mr) -> {
            modelocaminho.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel()
            });
        });
    }

    public void limparatracado() {
        txtcodigoatracado.setText("");
        txteditarresponsavelatracado.setText("");
        visualizaratracado();
    }

    public void visualizaratracado() {

        DefaultTableModel modeloatracado = (DefaultTableModel) jTableatracado.getModel();
        modeloatracado.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.visualizaratracado().forEach((mr) -> {
            modeloatracado.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel()
            });
        });
    }

    public void procuraratracado(int codigo) {
        DefaultTableModel modeloatracado = (DefaultTableModel) jTableatracado.getModel();
        modeloatracado.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.procuraratracado(codigo).forEach((mr) -> {
            modeloatracado.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel()
            });
        });
    }

    public void limpararmazem() {
        txtcodigoarmazem.setText("");
        txteditarresponsavelarmazem.setText("");
        visualizararmazem();
    }

    public void visualizararmazem() {

        DefaultTableModel modeloarmazem = (DefaultTableModel) jTablearmazem.getModel();
        modeloarmazem.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.visualizararmazem().forEach((mr) -> {
            modeloarmazem.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel(),
                mr.getChegada()
            });
        });
    }

    public void procurararmazem(int codigo) {
        DefaultTableModel modeloarmazem = (DefaultTableModel) jTablearmazem.getModel();
        modeloarmazem.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.procurararmazem(codigo).forEach((mr) -> {
            modeloarmazem.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel(),
                mr.getChegada()
            });
        });
    }

    public void limpardespachada() {
        txtcodigodespachada.setText("");
        visualizardespachada();
    }

    public void visualizardespachada() {

        DefaultTableModel modelodespachada = (DefaultTableModel) jTabledespachada.getModel();
        modelodespachada.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.visualizardespachada().forEach((mr) -> {
            modelodespachada.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel(),
                mr.getChegada(),
                mr.getPartida()
            });
        });
    }

    public void procurardespachada(int codigo) {
        DefaultTableModel modelodespachada = (DefaultTableModel) jTabledespachada.getModel();
        modelodespachada.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.procurardespachada(codigo).forEach((mr) -> {
            modelodespachada.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel(),
                mr.getChegada(),
                mr.getPartida()
            });
        });
    }

    public void limparapreendida() {
        txtcodigoapreendida.setText("");
        visualizarapreendida();
    }

    public void visualizarapreendida() {

        DefaultTableModel modeloapreendida = (DefaultTableModel) jTableapreendida.getModel();
        modeloapreendida.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.visualizarapreendida().forEach((mr) -> {
            modeloapreendida.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel(),
                mr.getChegada()
            });
        });
    }

    public void procurarapreendida(int codigo) {
        DefaultTableModel modeloapreendida = (DefaultTableModel) jTableapreendida.getModel();
        modeloapreendida.setNumRows(0);
        mercadoriadao mrdao = new mercadoriadao();
        mrdao.procurarapreendida(codigo).forEach((mr) -> {
            modeloapreendida.addRow(new Object[]{
                mr.getCodigo(),
                mr.getNavio(),
                mr.getSituacao(),
                mr.getTipo(),
                mr.getQuantidade(),
                mr.getResponsavel(),
                mr.getChegada()
            });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelfundo = new javax.swing.JPanel();
        noticia = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcodigonoticia = new javax.swing.JTextField();
        txttitulonoticia = new javax.swing.JTextField();
        btnapagarnoticia = new javax.swing.JButton();
        btnlimparnoticia = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btncadastrarnoticia = new javax.swing.JButton();
        btneditarnoticia = new javax.swing.JButton();
        btnprocurarnoticia = new javax.swing.JButton();
        txtdescricaonoticia = new javax.swing.JTextArea();
        jScrollPanenoticia = new javax.swing.JScrollPane();
        jTablenoticia = new javax.swing.JTable();
        autoridade = new javax.swing.JInternalFrame();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttelefoneautoridade = new javax.swing.JTextField();
        txtenderecoautoridade = new javax.swing.JTextField();
        txtemailautoridade = new javax.swing.JTextField();
        txtnomeautoridade = new javax.swing.JTextField();
        txtnupautoridade = new javax.swing.JTextField();
        cbocargoautoridade = new javax.swing.JComboBox<>();
        btnlimparautoridade = new javax.swing.JButton();
        btneditarautoridade = new javax.swing.JButton();
        btnrecontratarautoridade = new javax.swing.JButton();
        btncadastrarautoridade = new javax.swing.JButton();
        btnprocurarautoridade = new javax.swing.JButton();
        btndespedirautoridade = new javax.swing.JButton();
        jScrollPaneautoridade = new javax.swing.JScrollPane();
        jTableautoridade = new javax.swing.JTable();
        navio = new javax.swing.JInternalFrame();
        btncancelarchegadanavio = new javax.swing.JButton();
        btncancelarpartidanavio = new javax.swing.JButton();
        txtnupnavio = new javax.swing.JTextField();
        jScrollPanenavio = new javax.swing.JScrollPane();
        jTablenavio = new javax.swing.JTable();
        btnprocurarnavio = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnapagarnavio = new javax.swing.JButton();
        btnlimparnavio = new javax.swing.JButton();
        btnatracarnavio = new javax.swing.JButton();
        usuario = new javax.swing.JInternalFrame();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtnupusuario = new javax.swing.JTextField();
        cbonupusuario = new javax.swing.JComboBox<>();
        btnlimparusuario = new javax.swing.JButton();
        btncadastrarusuario = new javax.swing.JButton();
        btnprocurarusuario = new javax.swing.JButton();
        txtsenhausuario = new javax.swing.JPasswordField();
        jScrollPaneautoridade1 = new javax.swing.JScrollPane();
        jTablecontrole = new javax.swing.JTable();
        btneditarsenhausuario = new javax.swing.JButton();
        jScrollPaneautoridade2 = new javax.swing.JScrollPane();
        jTableusuario = new javax.swing.JTable();
        responsavel = new javax.swing.JInternalFrame();
        btnprocurarresponsavel = new javax.swing.JButton();
        txtnupresponsavel = new javax.swing.JTextField();
        jScrollPaneresponsavel = new javax.swing.JScrollPane();
        jTableresponsavel = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btnapagarresponsavel = new javax.swing.JButton();
        btnlimparresponsavel = new javax.swing.JButton();
        mercadoria = new javax.swing.JInternalFrame();
        jTabbedmercadoria = new javax.swing.JTabbedPane();
        caminho = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtcodigocaminho = new javax.swing.JTextField();
        btnprocurarcaminho = new javax.swing.JButton();
        btnapagarcaminho = new javax.swing.JButton();
        btnlimparcaminho = new javax.swing.JButton();
        jScrollPanecaminho = new javax.swing.JScrollPane();
        jTablecaminho = new javax.swing.JTable();
        btneditarresponsavelcaminho = new javax.swing.JButton();
        txteditarresponsavelcaminho = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        atracado = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtcodigoatracado = new javax.swing.JTextField();
        btnprocuraratracado = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txteditarresponsavelatracado = new javax.swing.JTextField();
        btneditarresponsavelatracado = new javax.swing.JButton();
        btnapagaratracado = new javax.swing.JButton();
        btnlimparatracado = new javax.swing.JButton();
        jScrollPaneatracado = new javax.swing.JScrollPane();
        jTableatracado = new javax.swing.JTable();
        armazem = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtcodigoarmazem = new javax.swing.JTextField();
        jScrollPanearmazem = new javax.swing.JScrollPane();
        jTablearmazem = new javax.swing.JTable();
        btnprocurarmazem = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txteditarresponsavelarmazem = new javax.swing.JTextField();
        btneditarresponsavelarmazem = new javax.swing.JButton();
        btnapagararmazem = new javax.swing.JButton();
        btnlimpararmazem = new javax.swing.JButton();
        btneditarresponsavelarmazem1 = new javax.swing.JButton();
        btneditarresponsavelarmazem2 = new javax.swing.JButton();
        despachada = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtcodigodespachada = new javax.swing.JTextField();
        btnprocurdespachada = new javax.swing.JButton();
        btnlimpardespachada = new javax.swing.JButton();
        jScrollPanedespachada = new javax.swing.JScrollPane();
        jTabledespachada = new javax.swing.JTable();
        apreendida = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtcodigoapreendida = new javax.swing.JTextField();
        btnprocurapreendida = new javax.swing.JButton();
        btnlimparapreendida = new javax.swing.JButton();
        jScrollPaneapreendida = new javax.swing.JScrollPane();
        jTableapreendida = new javax.swing.JTable();
        comboio = new javax.swing.JInternalFrame();
        jLabel18 = new javax.swing.JLabel();
        txtnupcomboio = new javax.swing.JTextField();
        btnapagarcomboio = new javax.swing.JButton();
        btnprocurarcomboio = new javax.swing.JButton();
        btncancelarchegadacomboio = new javax.swing.JButton();
        btnlimparcomboio = new javax.swing.JButton();
        btncancelarpartidacomboio = new javax.swing.JButton();
        jScrollPanecomboio = new javax.swing.JScrollPane();
        jTablecomboio = new javax.swing.JTable();
        camiao = new javax.swing.JInternalFrame();
        jLabel17 = new javax.swing.JLabel();
        txtnupcamiao = new javax.swing.JTextField();
        btnprocurarcamiao = new javax.swing.JButton();
        btnlimparcamiao = new javax.swing.JButton();
        btnapagarcamiao = new javax.swing.JButton();
        btncancelarchegadacamiao = new javax.swing.JButton();
        jScrollPanecamiao = new javax.swing.JScrollPane();
        jTablecamiao = new javax.swing.JTable();
        jLabellogo = new javax.swing.JLabel();
        btnfechar = new javax.swing.JButton();
        btnresponsavel = new javax.swing.JButton();
        btncamiao = new javax.swing.JButton();
        btncomboio = new javax.swing.JButton();
        btnmercadoria = new javax.swing.JButton();
        btnnavio = new javax.swing.JButton();
        btnautoridade = new javax.swing.JButton();
        btnnoticia = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        btnusuario = new javax.swing.JButton();
        jSeparatordivisao = new javax.swing.JSeparator();
        jLabelfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Número Único Portuário | NUP");
        setName("admin"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelfundo.setPreferredSize(new java.awt.Dimension(1370, 770));
        jPanelfundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noticia.setBorder(null);
        noticia.setTitle("Noticia");
        noticia.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        noticia.setVisible(false);
        noticia.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Codigo");
        noticia.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Titulo");
        noticia.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        txtcodigonoticia.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtcodigonoticia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcodigonoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigonoticiaActionPerformed(evt);
            }
        });
        noticia.getContentPane().add(txtcodigonoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 210, -1));

        txttitulonoticia.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txttitulonoticia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        noticia.getContentPane().add(txttitulonoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 1000, -1));

        btnapagarnoticia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnapagarnoticia.setText("Apagar");
        btnapagarnoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarnoticiaActionPerformed(evt);
            }
        });
        noticia.getContentPane().add(btnapagarnoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, -1, -1));

        btnlimparnoticia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparnoticia.setText("Limpar");
        btnlimparnoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparnoticiaActionPerformed(evt);
            }
        });
        noticia.getContentPane().add(btnlimparnoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Descricao");
        noticia.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        btncadastrarnoticia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btncadastrarnoticia.setText("Cadastrar");
        btncadastrarnoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarnoticiaActionPerformed(evt);
            }
        });
        noticia.getContentPane().add(btncadastrarnoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        btneditarnoticia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btneditarnoticia.setText("Editar");
        btneditarnoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarnoticiaActionPerformed(evt);
            }
        });
        noticia.getContentPane().add(btneditarnoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        btnprocurarnoticia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarnoticia.setText("Procurar");
        btnprocurarnoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarnoticiaActionPerformed(evt);
            }
        });
        noticia.getContentPane().add(btnprocurarnoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        txtdescricaonoticia.setColumns(20);
        txtdescricaonoticia.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtdescricaonoticia.setLineWrap(true);
        txtdescricaonoticia.setRows(5);
        txtdescricaonoticia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtdescricaonoticia.setPreferredSize(new java.awt.Dimension(1250, 224));
        noticia.getContentPane().add(txtdescricaonoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jScrollPanenoticia.setBorder(null);
        jScrollPanenoticia.setPreferredSize(new java.awt.Dimension(1360, 280));

        jTablenoticia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Titulo", "Descricao", "Escritor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablenoticia.setOpaque(false);
        jTablenoticia.setPreferredSize(new java.awt.Dimension(1350, 230));
        jTablenoticia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablenoticiaMouseClicked(evt);
            }
        });
        jTablenoticia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablenoticiaKeyReleased(evt);
            }
        });
        jScrollPanenoticia.setViewportView(jTablenoticia);
        if (jTablenoticia.getColumnModel().getColumnCount() > 0) {
            jTablenoticia.getColumnModel().getColumn(0).setResizable(false);
            jTablenoticia.getColumnModel().getColumn(0).setPreferredWidth(11);
        }

        noticia.getContentPane().add(jScrollPanenoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 1340, 260));

        jPanelfundo.add(noticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1370, 670));

        autoridade.setBorder(null);
        autoridade.setTitle("Autoridade Portuaria");
        autoridade.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        autoridade.setPreferredSize(new java.awt.Dimension(1370, 670));
        autoridade.setVisible(false);
        autoridade.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Endereco");
        autoridade.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Email");
        autoridade.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Nome");
        autoridade.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Cargo");
        autoridade.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Telefone");
        autoridade.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("NUP");
        autoridade.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txttelefoneautoridade.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txttelefoneautoridade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttelefoneautoridade.setPreferredSize(new java.awt.Dimension(300, 50));
        txttelefoneautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefoneautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(txttelefoneautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        txtenderecoautoridade.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtenderecoautoridade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        autoridade.getContentPane().add(txtenderecoautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 700, -1));

        txtemailautoridade.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtemailautoridade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtemailautoridade.setPreferredSize(new java.awt.Dimension(500, 50));
        txtemailautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(txtemailautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        txtnomeautoridade.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtnomeautoridade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnomeautoridade.setPreferredSize(new java.awt.Dimension(18, 50));
        autoridade.getContentPane().add(txtnomeautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 1050, -1));

        txtnupautoridade.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtnupautoridade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnupautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnupautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(txtnupautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, -1));

        cbocargoautoridade.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cbocargoautoridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Analista de Importação", "Auxiliar de Mecânica", "Coordenador de  Logística", "Coordenador de Transportes", "Assistente Administrativo ", "Despachante Aduaneiro", "Administrador", "Analista de Importação", "Analista de Sistema", "Analista de Operações Marítimas", "Analista de Comércio Exterior ", "Operador de Empilhadeira Grande Porte", "Operador de Empilhadeira Pequeno Porte", "Auxiliar de Armazém", "Mecânico de equipamentos", "Gerente Comercial", "Técnico Reefer", "Recepcionista", "Alfandegas", "Saude", "Migracao" }));
        cbocargoautoridade.setBorder(null);
        cbocargoautoridade.setPreferredSize(new java.awt.Dimension(300, 50));
        cbocargoautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocargoautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(cbocargoautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 500, -1));

        btnlimparautoridade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparautoridade.setText("Limpar");
        btnlimparautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(btnlimparautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        btneditarautoridade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btneditarautoridade.setText("Editar");
        btneditarautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(btneditarautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        btnrecontratarautoridade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnrecontratarautoridade.setText("Recontratar");
        btnrecontratarautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecontratarautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(btnrecontratarautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, -1, -1));

        btncadastrarautoridade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btncadastrarautoridade.setText("Cadastrar");
        btncadastrarautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(btncadastrarautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        btnprocurarautoridade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarautoridade.setText("Procurar");
        btnprocurarautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(btnprocurarautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        btndespedirautoridade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btndespedirautoridade.setText("Despedir");
        btndespedirautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndespedirautoridadeActionPerformed(evt);
            }
        });
        autoridade.getContentPane().add(btndespedirautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

        jScrollPaneautoridade.setBorder(null);

        jTableautoridade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUP", "Nome", "Telefone", "Email", "Endereco", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableautoridade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableautoridadeMouseClicked(evt);
            }
        });
        jTableautoridade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableautoridadeKeyReleased(evt);
            }
        });
        jScrollPaneautoridade.setViewportView(jTableautoridade);
        if (jTableautoridade.getColumnModel().getColumnCount() > 0) {
            jTableautoridade.getColumnModel().getColumn(0).setResizable(false);
            jTableautoridade.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTableautoridade.getColumnModel().getColumn(1).setResizable(false);
            jTableautoridade.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTableautoridade.getColumnModel().getColumn(2).setResizable(false);
            jTableautoridade.getColumnModel().getColumn(2).setPreferredWidth(11);
        }

        autoridade.getContentPane().add(jScrollPaneautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 1330, 300));

        jPanelfundo.add(autoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        navio.setBorder(null);
        navio.setTitle("Navio");
        navio.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        navio.setPreferredSize(new java.awt.Dimension(1370, 670));
        navio.setVisible(false);
        navio.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncancelarchegadanavio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btncancelarchegadanavio.setText("Cancelar Chegada");
        btncancelarchegadanavio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarchegadanavioActionPerformed(evt);
            }
        });
        navio.getContentPane().add(btncancelarchegadanavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        btncancelarpartidanavio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btncancelarpartidanavio.setText("Cancelar Partida");
        btncancelarpartidanavio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarpartidanavioActionPerformed(evt);
            }
        });
        navio.getContentPane().add(btncancelarpartidanavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 30, -1, -1));

        txtnupnavio.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtnupnavio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnupnavio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnupnavioActionPerformed(evt);
            }
        });
        navio.getContentPane().add(txtnupnavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, -1));

        jTablenavio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUP", "Matricula", "Nome", "Telefone", "Email", "Tipo de Embarcacao", "Pais", "Passageiros/ Tripulates", "Chegada", "Partida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablenavio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablenavioMouseClicked(evt);
            }
        });
        jTablenavio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablenavioKeyReleased(evt);
            }
        });
        jScrollPanenavio.setViewportView(jTablenavio);
        if (jTablenavio.getColumnModel().getColumnCount() > 0) {
            jTablenavio.getColumnModel().getColumn(0).setResizable(false);
            jTablenavio.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTablenavio.getColumnModel().getColumn(3).setResizable(false);
            jTablenavio.getColumnModel().getColumn(3).setPreferredWidth(25);
            jTablenavio.getColumnModel().getColumn(7).setResizable(false);
            jTablenavio.getColumnModel().getColumn(7).setPreferredWidth(11);
            jTablenavio.getColumnModel().getColumn(8).setResizable(false);
            jTablenavio.getColumnModel().getColumn(8).setPreferredWidth(10);
            jTablenavio.getColumnModel().getColumn(9).setResizable(false);
            jTablenavio.getColumnModel().getColumn(9).setPreferredWidth(10);
        }

        navio.getContentPane().add(jScrollPanenavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1350, 500));

        btnprocurarnavio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarnavio.setText("Procurar");
        btnprocurarnavio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarnavioActionPerformed(evt);
            }
        });
        navio.getContentPane().add(btnprocurarnavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Codigo");
        navio.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnapagarnavio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnapagarnavio.setText("Apagar");
        btnapagarnavio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarnavioActionPerformed(evt);
            }
        });
        navio.getContentPane().add(btnapagarnavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        btnlimparnavio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparnavio.setText("Limpar");
        btnlimparnavio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparnavioActionPerformed(evt);
            }
        });
        navio.getContentPane().add(btnlimparnavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        btnatracarnavio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnatracarnavio.setText("Atracar");
        btnatracarnavio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatracarnavioActionPerformed(evt);
            }
        });
        navio.getContentPane().add(btnatracarnavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, -1));

        jPanelfundo.add(navio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        usuario.setBorder(null);
        usuario.setTitle("Usuario");
        usuario.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        usuario.setPreferredSize(new java.awt.Dimension(1370, 670));
        usuario.setVisible(false);
        usuario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Funcionario");
        usuario.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Senha");
        usuario.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("NUP");
        usuario.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtnupusuario.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtnupusuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnupusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnupusuarioActionPerformed(evt);
            }
        });
        usuario.getContentPane().add(txtnupusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, -1));

        cbonupusuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cbonupusuario.setBorder(null);
        cbonupusuario.setPreferredSize(new java.awt.Dimension(300, 50));
        usuario.getContentPane().add(cbonupusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 250, -1));

        btnlimparusuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparusuario.setText("Limpar");
        btnlimparusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparusuarioActionPerformed(evt);
            }
        });
        usuario.getContentPane().add(btnlimparusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        btncadastrarusuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btncadastrarusuario.setText("Cadastrar");
        btncadastrarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarusuarioActionPerformed(evt);
            }
        });
        usuario.getContentPane().add(btncadastrarusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        btnprocurarusuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarusuario.setText("Procurar");
        btnprocurarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarusuarioActionPerformed(evt);
            }
        });
        usuario.getContentPane().add(btnprocurarusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        txtsenhausuario.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtsenhausuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtsenhausuario.setPreferredSize(new java.awt.Dimension(300, 50));
        usuario.getContentPane().add(txtsenhausuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 400, -1));

        jScrollPaneautoridade1.setBorder(null);

        jTablecontrole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUP", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablecontrole.getTableHeader().setReorderingAllowed(false);
        jTablecontrole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablecontroleMouseClicked(evt);
            }
        });
        jTablecontrole.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablecontroleKeyReleased(evt);
            }
        });
        jScrollPaneautoridade1.setViewportView(jTablecontrole);
        if (jTablecontrole.getColumnModel().getColumnCount() > 0) {
            jTablecontrole.getColumnModel().getColumn(0).setResizable(false);
            jTablecontrole.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTablecontrole.getColumnModel().getColumn(1).setResizable(false);
            jTablecontrole.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        usuario.getContentPane().add(jScrollPaneautoridade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 360, 500));

        btneditarsenhausuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btneditarsenhausuario.setText("Editar Senha");
        btneditarsenhausuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarsenhausuarioActionPerformed(evt);
            }
        });
        usuario.getContentPane().add(btneditarsenhausuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jScrollPaneautoridade2.setBorder(null);

        jTableusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUP", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableusuarioMouseClicked(evt);
            }
        });
        jTableusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableusuarioKeyReleased(evt);
            }
        });
        jScrollPaneautoridade2.setViewportView(jTableusuario);
        if (jTableusuario.getColumnModel().getColumnCount() > 0) {
            jTableusuario.getColumnModel().getColumn(0).setResizable(false);
            jTableusuario.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTableusuario.getColumnModel().getColumn(1).setResizable(false);
            jTableusuario.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        usuario.getContentPane().add(jScrollPaneautoridade2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 290, 440));

        jPanelfundo.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        responsavel.setBorder(null);
        responsavel.setTitle("Responsavel");
        responsavel.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        responsavel.setPreferredSize(new java.awt.Dimension(1370, 670));
        responsavel.setVisible(false);
        responsavel.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnprocurarresponsavel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarresponsavel.setText("Procurar");
        btnprocurarresponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarresponsavelActionPerformed(evt);
            }
        });
        responsavel.getContentPane().add(btnprocurarresponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        txtnupresponsavel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtnupresponsavel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnupresponsavel.setPreferredSize(new java.awt.Dimension(250, 50));
        responsavel.getContentPane().add(txtnupresponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTableresponsavel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUP", "Nome", "Telefone", "Email", "Endereco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jTableresponsavel.setOpaque(false);
        jTableresponsavel.setPreferredSize(new java.awt.Dimension(1350, 500));
        jTableresponsavel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableresponsavelMouseClicked(evt);
            }
        });
        jTableresponsavel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableresponsavelKeyReleased(evt);
            }
        });
        jScrollPaneresponsavel.setViewportView(jTableresponsavel);
        if (jTableresponsavel.getColumnModel().getColumnCount() > 0) {
            jTableresponsavel.getColumnModel().getColumn(0).setResizable(false);
            jTableresponsavel.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTableresponsavel.getColumnModel().getColumn(2).setResizable(false);
            jTableresponsavel.getColumnModel().getColumn(2).setPreferredWidth(25);
        }

        responsavel.getContentPane().add(jScrollPaneresponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1350, 510));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Codigo");
        responsavel.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnapagarresponsavel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnapagarresponsavel.setText("Apagar");
        btnapagarresponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarresponsavelActionPerformed(evt);
            }
        });
        responsavel.getContentPane().add(btnapagarresponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        btnlimparresponsavel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparresponsavel.setText("Limpar");
        btnlimparresponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparresponsavelActionPerformed(evt);
            }
        });
        responsavel.getContentPane().add(btnlimparresponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        jPanelfundo.add(responsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        mercadoria.setBorder(null);
        mercadoria.setTitle("Mercadoria");
        mercadoria.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        mercadoria.setPreferredSize(new java.awt.Dimension(1370, 670));
        mercadoria.setVisible(false);
        mercadoria.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedmercadoria.setPreferredSize(new java.awt.Dimension(1365, 640));

        caminho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Codigo");
        caminho.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtcodigocaminho.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtcodigocaminho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcodigocaminho.setPreferredSize(new java.awt.Dimension(250, 50));
        caminho.add(txtcodigocaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        btnprocurarcaminho.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarcaminho.setText("Procurar");
        btnprocurarcaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarcaminhoActionPerformed(evt);
            }
        });
        caminho.add(btnprocurarcaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        btnapagarcaminho.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnapagarcaminho.setText("Apagar");
        btnapagarcaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarcaminhoActionPerformed(evt);
            }
        });
        caminho.add(btnapagarcaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, -1, -1));

        btnlimparcaminho.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparcaminho.setText("Limpar");
        btnlimparcaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparcaminhoActionPerformed(evt);
            }
        });
        caminho.add(btnlimparcaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, -1));

        jScrollPanecaminho.setPreferredSize(new java.awt.Dimension(1345, 480));

        jTablecaminho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Navio", "Situacao da Mercadoria", "Tipo de Mercadoria", "Quantidade", "Responsavel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablecaminho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablecaminhoMouseClicked(evt);
            }
        });
        jTablecaminho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablecaminhoKeyReleased(evt);
            }
        });
        jScrollPanecaminho.setViewportView(jTablecaminho);
        if (jTablecaminho.getColumnModel().getColumnCount() > 0) {
            jTablecaminho.getColumnModel().getColumn(0).setResizable(false);
            jTablecaminho.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTablecaminho.getColumnModel().getColumn(1).setResizable(false);
            jTablecaminho.getColumnModel().getColumn(1).setPreferredWidth(11);
            jTablecaminho.getColumnModel().getColumn(4).setResizable(false);
            jTablecaminho.getColumnModel().getColumn(4).setPreferredWidth(11);
            jTablecaminho.getColumnModel().getColumn(5).setResizable(false);
            jTablecaminho.getColumnModel().getColumn(5).setPreferredWidth(11);
        }

        caminho.add(jScrollPanecaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        btneditarresponsavelcaminho.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btneditarresponsavelcaminho.setText("Editar Responsavel");
        btneditarresponsavelcaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarresponsavelcaminhoActionPerformed(evt);
            }
        });
        caminho.add(btneditarresponsavelcaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        txteditarresponsavelcaminho.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txteditarresponsavelcaminho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txteditarresponsavelcaminho.setPreferredSize(new java.awt.Dimension(250, 50));
        caminho.add(txteditarresponsavelcaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Responsavel");
        caminho.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jTabbedmercadoria.addTab("A Caminho", caminho);

        atracado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Codigo");
        atracado.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtcodigoatracado.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtcodigoatracado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcodigoatracado.setPreferredSize(new java.awt.Dimension(250, 50));
        atracado.add(txtcodigoatracado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        btnprocuraratracado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocuraratracado.setText("Procurar");
        btnprocuraratracado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocuraratracadoActionPerformed(evt);
            }
        });
        atracado.add(btnprocuraratracado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Responsavel");
        atracado.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        txteditarresponsavelatracado.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txteditarresponsavelatracado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txteditarresponsavelatracado.setPreferredSize(new java.awt.Dimension(250, 50));
        atracado.add(txteditarresponsavelatracado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        btneditarresponsavelatracado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btneditarresponsavelatracado.setText("Editar Responsavel");
        btneditarresponsavelatracado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarresponsavelatracadoActionPerformed(evt);
            }
        });
        atracado.add(btneditarresponsavelatracado, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        btnapagaratracado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnapagaratracado.setText("Apagar");
        btnapagaratracado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagaratracadoActionPerformed(evt);
            }
        });
        atracado.add(btnapagaratracado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, -1, -1));

        btnlimparatracado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparatracado.setText("Limpar");
        btnlimparatracado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparatracadoActionPerformed(evt);
            }
        });
        atracado.add(btnlimparatracado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, -1));

        jScrollPaneatracado.setPreferredSize(new java.awt.Dimension(1345, 480));

        jTableatracado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Navio", "Situacao da Mercadoria", "Tipo de Mercadoria", "Quantidade", "Responsavel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableatracado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableatracadoMouseClicked(evt);
            }
        });
        jTableatracado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableatracadoKeyReleased(evt);
            }
        });
        jScrollPaneatracado.setViewportView(jTableatracado);
        if (jTableatracado.getColumnModel().getColumnCount() > 0) {
            jTableatracado.getColumnModel().getColumn(0).setResizable(false);
            jTableatracado.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTableatracado.getColumnModel().getColumn(1).setResizable(false);
            jTableatracado.getColumnModel().getColumn(1).setPreferredWidth(11);
            jTableatracado.getColumnModel().getColumn(4).setResizable(false);
            jTableatracado.getColumnModel().getColumn(4).setPreferredWidth(11);
            jTableatracado.getColumnModel().getColumn(5).setResizable(false);
            jTableatracado.getColumnModel().getColumn(5).setPreferredWidth(11);
        }

        atracado.add(jScrollPaneatracado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jTabbedmercadoria.addTab("No Navio Atracado", atracado);

        armazem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Codigo");
        armazem.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtcodigoarmazem.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtcodigoarmazem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcodigoarmazem.setPreferredSize(new java.awt.Dimension(250, 50));
        armazem.add(txtcodigoarmazem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jScrollPanearmazem.setPreferredSize(new java.awt.Dimension(1345, 480));

        jTablearmazem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Navio", "Situacao da Mercadoria", "Tipo de Mercadoria", "Quantidade", "Responsavel", "Chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablearmazem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablearmazemMouseClicked(evt);
            }
        });
        jTablearmazem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablearmazemKeyReleased(evt);
            }
        });
        jScrollPanearmazem.setViewportView(jTablearmazem);
        if (jTablearmazem.getColumnModel().getColumnCount() > 0) {
            jTablearmazem.getColumnModel().getColumn(0).setResizable(false);
            jTablearmazem.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTablearmazem.getColumnModel().getColumn(1).setResizable(false);
            jTablearmazem.getColumnModel().getColumn(1).setPreferredWidth(11);
            jTablearmazem.getColumnModel().getColumn(4).setResizable(false);
            jTablearmazem.getColumnModel().getColumn(4).setPreferredWidth(11);
            jTablearmazem.getColumnModel().getColumn(5).setResizable(false);
            jTablearmazem.getColumnModel().getColumn(5).setPreferredWidth(11);
            jTablearmazem.getColumnModel().getColumn(6).setResizable(false);
            jTablearmazem.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        armazem.add(jScrollPanearmazem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        btnprocurarmazem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarmazem.setText("Procurar");
        btnprocurarmazem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarmazemActionPerformed(evt);
            }
        });
        armazem.add(btnprocurarmazem, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Responsavel");
        armazem.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        txteditarresponsavelarmazem.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txteditarresponsavelarmazem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txteditarresponsavelarmazem.setPreferredSize(new java.awt.Dimension(250, 50));
        armazem.add(txteditarresponsavelarmazem, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        btneditarresponsavelarmazem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btneditarresponsavelarmazem.setText("Editar Responsavel");
        btneditarresponsavelarmazem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarresponsavelarmazemActionPerformed(evt);
            }
        });
        armazem.add(btneditarresponsavelarmazem, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        btnapagararmazem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnapagararmazem.setText("Apagar");
        btnapagararmazem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagararmazemActionPerformed(evt);
            }
        });
        armazem.add(btnapagararmazem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, -1, -1));

        btnlimpararmazem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimpararmazem.setText("Limpar");
        btnlimpararmazem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpararmazemActionPerformed(evt);
            }
        });
        armazem.add(btnlimpararmazem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, -1));

        btneditarresponsavelarmazem1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btneditarresponsavelarmazem1.setText("Cancelar Chegada");
        btneditarresponsavelarmazem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarresponsavelarmazem1ActionPerformed(evt);
            }
        });
        armazem.add(btneditarresponsavelarmazem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, -1, -1));

        btneditarresponsavelarmazem2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btneditarresponsavelarmazem2.setText("Apreender");
        btneditarresponsavelarmazem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarresponsavelarmazem2ActionPerformed(evt);
            }
        });
        armazem.add(btneditarresponsavelarmazem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, -1));

        jTabbedmercadoria.addTab("No Armazem", armazem);

        despachada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Codigo");
        despachada.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtcodigodespachada.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtcodigodespachada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcodigodespachada.setPreferredSize(new java.awt.Dimension(250, 50));
        despachada.add(txtcodigodespachada, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        btnprocurdespachada.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurdespachada.setText("Procurar");
        btnprocurdespachada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurdespachadaActionPerformed(evt);
            }
        });
        despachada.add(btnprocurdespachada, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        btnlimpardespachada.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimpardespachada.setText("Limpar");
        btnlimpardespachada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpardespachadaActionPerformed(evt);
            }
        });
        despachada.add(btnlimpardespachada, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jScrollPanedespachada.setPreferredSize(new java.awt.Dimension(1345, 480));

        jTabledespachada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Navio", "Situacao da Mercadoria", "Tipo de Mercadoria", "Quantidade", "Responsavel", "Chegada", "Partida", "Preco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabledespachada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabledespachadaMouseClicked(evt);
            }
        });
        jTabledespachada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTabledespachadaKeyReleased(evt);
            }
        });
        jScrollPanedespachada.setViewportView(jTabledespachada);
        if (jTabledespachada.getColumnModel().getColumnCount() > 0) {
            jTabledespachada.getColumnModel().getColumn(0).setResizable(false);
            jTabledespachada.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTabledespachada.getColumnModel().getColumn(1).setResizable(false);
            jTabledespachada.getColumnModel().getColumn(1).setPreferredWidth(11);
            jTabledespachada.getColumnModel().getColumn(4).setResizable(false);
            jTabledespachada.getColumnModel().getColumn(4).setPreferredWidth(11);
            jTabledespachada.getColumnModel().getColumn(5).setResizable(false);
            jTabledespachada.getColumnModel().getColumn(5).setPreferredWidth(11);
            jTabledespachada.getColumnModel().getColumn(6).setResizable(false);
            jTabledespachada.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTabledespachada.getColumnModel().getColumn(7).setResizable(false);
            jTabledespachada.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        despachada.add(jScrollPanedespachada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jTabbedmercadoria.addTab("Despachada", despachada);

        apreendida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Codigo");
        apreendida.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtcodigoapreendida.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtcodigoapreendida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcodigoapreendida.setPreferredSize(new java.awt.Dimension(250, 50));
        txtcodigoapreendida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoapreendidaActionPerformed(evt);
            }
        });
        apreendida.add(txtcodigoapreendida, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        btnprocurapreendida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurapreendida.setText("Procurar");
        btnprocurapreendida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurapreendidaActionPerformed(evt);
            }
        });
        apreendida.add(btnprocurapreendida, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        btnlimparapreendida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparapreendida.setText("Limpar");
        btnlimparapreendida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparapreendidaActionPerformed(evt);
            }
        });
        apreendida.add(btnlimparapreendida, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jScrollPaneapreendida.setPreferredSize(new java.awt.Dimension(1345, 480));

        jTableapreendida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Navio", "Situacao da Mercadoria", "Tipo de Mercadoria", "Quantidade", "Responsavel", "Chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableapreendida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableapreendidaMouseClicked(evt);
            }
        });
        jTableapreendida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableapreendidaKeyReleased(evt);
            }
        });
        jScrollPaneapreendida.setViewportView(jTableapreendida);
        if (jTableapreendida.getColumnModel().getColumnCount() > 0) {
            jTableapreendida.getColumnModel().getColumn(0).setResizable(false);
            jTableapreendida.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTableapreendida.getColumnModel().getColumn(1).setResizable(false);
            jTableapreendida.getColumnModel().getColumn(1).setPreferredWidth(11);
            jTableapreendida.getColumnModel().getColumn(4).setResizable(false);
            jTableapreendida.getColumnModel().getColumn(4).setPreferredWidth(11);
            jTableapreendida.getColumnModel().getColumn(5).setResizable(false);
            jTableapreendida.getColumnModel().getColumn(5).setPreferredWidth(11);
            jTableapreendida.getColumnModel().getColumn(6).setResizable(false);
            jTableapreendida.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        apreendida.add(jScrollPaneapreendida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jTabbedmercadoria.addTab("Apreendida", apreendida);

        mercadoria.getContentPane().add(jTabbedmercadoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelfundo.add(mercadoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        comboio.setBorder(null);
        comboio.setTitle("Comboio");
        comboio.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        comboio.setPreferredSize(new java.awt.Dimension(1370, 670));
        comboio.setVisible(false);
        comboio.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Codigo");
        comboio.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtnupcomboio.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtnupcomboio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboio.getContentPane().add(txtnupcomboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, -1));

        btnapagarcomboio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnapagarcomboio.setText("Apagar");
        btnapagarcomboio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarcomboioActionPerformed(evt);
            }
        });
        comboio.getContentPane().add(btnapagarcomboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        btnprocurarcomboio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarcomboio.setText("Procurar");
        btnprocurarcomboio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarcomboioActionPerformed(evt);
            }
        });
        comboio.getContentPane().add(btnprocurarcomboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        btncancelarchegadacomboio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btncancelarchegadacomboio.setText("Cancelar Chegada");
        btncancelarchegadacomboio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarchegadacomboioActionPerformed(evt);
            }
        });
        comboio.getContentPane().add(btncancelarchegadacomboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        btnlimparcomboio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparcomboio.setText("Limpar");
        btnlimparcomboio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparcomboioActionPerformed(evt);
            }
        });
        comboio.getContentPane().add(btnlimparcomboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        btncancelarpartidacomboio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btncancelarpartidacomboio.setText("Cancelar Partida");
        btncancelarpartidacomboio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarpartidacomboioActionPerformed(evt);
            }
        });
        comboio.getContentPane().add(btncancelarpartidacomboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, -1, -1));

        jTablecomboio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUP", "Matricula", "Empresa", "Telefone", "Email", "Tipo de Comboio", "Pais", "Passageiros", "Data Chegada", "Data partida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablecomboio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablecomboioMouseClicked(evt);
            }
        });
        jTablecomboio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablecomboioKeyReleased(evt);
            }
        });
        jScrollPanecomboio.setViewportView(jTablecomboio);
        if (jTablecomboio.getColumnModel().getColumnCount() > 0) {
            jTablecomboio.getColumnModel().getColumn(0).setResizable(false);
            jTablecomboio.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTablecomboio.getColumnModel().getColumn(3).setResizable(false);
            jTablecomboio.getColumnModel().getColumn(3).setPreferredWidth(25);
            jTablecomboio.getColumnModel().getColumn(4).setResizable(false);
            jTablecomboio.getColumnModel().getColumn(7).setResizable(false);
            jTablecomboio.getColumnModel().getColumn(7).setPreferredWidth(11);
            jTablecomboio.getColumnModel().getColumn(8).setResizable(false);
            jTablecomboio.getColumnModel().getColumn(8).setPreferredWidth(10);
            jTablecomboio.getColumnModel().getColumn(9).setResizable(false);
            jTablecomboio.getColumnModel().getColumn(9).setPreferredWidth(10);
        }

        comboio.getContentPane().add(jScrollPanecomboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1350, 500));

        jPanelfundo.add(comboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        camiao.setBorder(null);
        camiao.setTitle("Camiao");
        camiao.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        camiao.setPreferredSize(new java.awt.Dimension(1370, 670));
        camiao.setVisible(false);
        camiao.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Codigo");
        camiao.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtnupcamiao.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtnupcamiao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnupcamiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnupcamiaoActionPerformed(evt);
            }
        });
        camiao.getContentPane().add(txtnupcamiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, -1));

        btnprocurarcamiao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprocurarcamiao.setText("Procurar");
        btnprocurarcamiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarcamiaoActionPerformed(evt);
            }
        });
        camiao.getContentPane().add(btnprocurarcamiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        btnlimparcamiao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnlimparcamiao.setText("Limpar");
        btnlimparcamiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparcamiaoActionPerformed(evt);
            }
        });
        camiao.getContentPane().add(btnlimparcamiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, -1, -1));

        btnapagarcamiao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnapagarcamiao.setText("Apagar");
        btnapagarcamiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarcamiaoActionPerformed(evt);
            }
        });
        camiao.getContentPane().add(btnapagarcamiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        btncancelarchegadacamiao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btncancelarchegadacamiao.setText("Cancelar Chegada");
        btncancelarchegadacamiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarchegadacamiaoActionPerformed(evt);
            }
        });
        camiao.getContentPane().add(btncancelarchegadacamiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jScrollPanecamiao.setPreferredSize(new java.awt.Dimension(1350, 500));

        jTablecamiao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUP", "Matricula", "Empresa", "Telefone", "Email", "Tipo de Camiao", "Pais", "Passageiros", "Chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablecamiao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablecamiaoMouseClicked(evt);
            }
        });
        jTablecamiao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablecamiaoKeyReleased(evt);
            }
        });
        jScrollPanecamiao.setViewportView(jTablecamiao);
        if (jTablecamiao.getColumnModel().getColumnCount() > 0) {
            jTablecamiao.getColumnModel().getColumn(0).setResizable(false);
            jTablecamiao.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTablecamiao.getColumnModel().getColumn(3).setResizable(false);
            jTablecamiao.getColumnModel().getColumn(3).setPreferredWidth(25);
            jTablecamiao.getColumnModel().getColumn(7).setResizable(false);
            jTablecamiao.getColumnModel().getColumn(7).setPreferredWidth(11);
            jTablecamiao.getColumnModel().getColumn(8).setResizable(false);
            jTablecamiao.getColumnModel().getColumn(8).setPreferredWidth(10);
        }

        camiao.getContentPane().add(jScrollPanecamiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jPanelfundo.add(camiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jLabellogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/logo.png"))); // NOI18N
        jLabellogo.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanelfundo.add(jLabellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 300, 300));

        btnfechar.setBackground(new java.awt.Color(204, 204, 204));
        btnfechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Fechar.png"))); // NOI18N
        btnfechar.setBorder(null);
        btnfechar.setBorderPainted(false);
        btnfechar.setOpaque(false);
        btnfechar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfecharActionPerformed(evt);
            }
        });
        jPanelfundo.add(btnfechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, -1, -1));

        btnresponsavel.setBackground(new java.awt.Color(204, 204, 204));
        btnresponsavel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/editado.png"))); // NOI18N
        btnresponsavel.setBorder(null);
        btnresponsavel.setBorderPainted(false);
        btnresponsavel.setOpaque(false);
        btnresponsavel.setPreferredSize(new java.awt.Dimension(80, 80));
        btnresponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresponsavelActionPerformed(evt);
            }
        });
        jPanelfundo.add(btnresponsavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        btncamiao.setBackground(new java.awt.Color(204, 204, 204));
        btncamiao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Camiao.png"))); // NOI18N
        btncamiao.setBorder(null);
        btncamiao.setBorderPainted(false);
        btncamiao.setOpaque(false);
        btncamiao.setPreferredSize(new java.awt.Dimension(80, 80));
        btncamiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncamiaoActionPerformed(evt);
            }
        });
        jPanelfundo.add(btncamiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

        btncomboio.setBackground(new java.awt.Color(204, 204, 204));
        btncomboio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Comboio.png"))); // NOI18N
        btncomboio.setBorder(null);
        btncomboio.setBorderPainted(false);
        btncomboio.setOpaque(false);
        btncomboio.setPreferredSize(new java.awt.Dimension(80, 80));
        btncomboio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomboioActionPerformed(evt);
            }
        });
        jPanelfundo.add(btncomboio, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        btnmercadoria.setBackground(new java.awt.Color(204, 204, 204));
        btnmercadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Mercadoria.png"))); // NOI18N
        btnmercadoria.setBorder(null);
        btnmercadoria.setBorderPainted(false);
        btnmercadoria.setOpaque(false);
        btnmercadoria.setPreferredSize(new java.awt.Dimension(80, 80));
        btnmercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmercadoriaActionPerformed(evt);
            }
        });
        jPanelfundo.add(btnmercadoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        btnnavio.setBackground(new java.awt.Color(204, 204, 204));
        btnnavio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Navio.png"))); // NOI18N
        btnnavio.setBorder(null);
        btnnavio.setBorderPainted(false);
        btnnavio.setOpaque(false);
        btnnavio.setPreferredSize(new java.awt.Dimension(80, 80));
        btnnavio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnavioActionPerformed(evt);
            }
        });
        jPanelfundo.add(btnnavio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        btnautoridade.setBackground(new java.awt.Color(204, 204, 204));
        btnautoridade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Autoridade.png"))); // NOI18N
        btnautoridade.setBorder(null);
        btnautoridade.setBorderPainted(false);
        btnautoridade.setOpaque(false);
        btnautoridade.setPreferredSize(new java.awt.Dimension(80, 80));
        btnautoridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnautoridadeActionPerformed(evt);
            }
        });
        jPanelfundo.add(btnautoridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        btnnoticia.setBackground(new java.awt.Color(204, 204, 204));
        btnnoticia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Noticia.png"))); // NOI18N
        btnnoticia.setBorder(null);
        btnnoticia.setBorderPainted(false);
        btnnoticia.setOpaque(false);
        btnnoticia.setPreferredSize(new java.awt.Dimension(80, 80));
        btnnoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnoticiaActionPerformed(evt);
            }
        });
        jPanelfundo.add(btnnoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        btnsair.setBackground(new java.awt.Color(204, 204, 204));
        btnsair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Sair.png"))); // NOI18N
        btnsair.setBorder(null);
        btnsair.setBorderPainted(false);
        btnsair.setOpaque(false);
        btnsair.setPreferredSize(new java.awt.Dimension(60, 60));
        btnsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsairActionPerformed(evt);
            }
        });
        jPanelfundo.add(btnsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnusuario.setBackground(new java.awt.Color(204, 204, 204));
        btnusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/usuario.png"))); // NOI18N
        btnusuario.setBorder(null);
        btnusuario.setBorderPainted(false);
        btnusuario.setOpaque(false);
        btnusuario.setPreferredSize(new java.awt.Dimension(80, 80));
        btnusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuarioActionPerformed(evt);
            }
        });
        jPanelfundo.add(btnusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, -1));

        jSeparatordivisao.setPreferredSize(new java.awt.Dimension(1370, 1));
        jPanelfundo.add(jSeparatordivisao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jLabelfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Mozambique_Maputo_Macamo.jpg"))); // NOI18N
        jLabelfundo.setPreferredSize(new java.awt.Dimension(1370, 670));
        jPanelfundo.add(jLabelfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        getContentPane().add(jPanelfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
        login tela = new login();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnsairActionPerformed

    private void btnnoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnoticiaActionPerformed
        noticia.setVisible(true);
        autoridade.setVisible(false);
        navio.setVisible(false);
        responsavel.setVisible(false);
        mercadoria.setVisible(false);
        comboio.setVisible(false);
        camiao.setVisible(false);
        usuario.setVisible(false);
        btnfechar.setVisible(true);
    }//GEN-LAST:event_btnnoticiaActionPerformed

    private void txtcodigonoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigonoticiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigonoticiaActionPerformed

    private void btncadastrarnoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarnoticiaActionPerformed
        if (txttitulonoticia.getText().equals("") || txtdescricaonoticia.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o titulo e/ou descricao.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            noticia n = new noticia();
            noticiadao dao = new noticiadao();
            n.setTitulo(txttitulonoticia.getText());
            n.setDescricao(txtdescricaonoticia.getText());
            n.setEscritor("MPDC");
            dao.cadastrar(n);
            limparnoticia();
            visualizarnoticia();
        }
    }//GEN-LAST:event_btncadastrarnoticiaActionPerformed

    private void btnlimparnoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparnoticiaActionPerformed
        limparnoticia();
        visualizarnoticia();
    }//GEN-LAST:event_btnlimparnoticiaActionPerformed

    private void jTablenoticiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablenoticiaMouseClicked
        if (jTablenoticia.getSelectedRow() != -1) {
            txtcodigonoticia.setText(jTablenoticia.getValueAt(jTablenoticia.getSelectedRow(), 0).toString());
            txttitulonoticia.setText(jTablenoticia.getValueAt(jTablenoticia.getSelectedRow(), 1).toString());
            txtdescricaonoticia.setText(jTablenoticia.getValueAt(jTablenoticia.getSelectedRow(), 2).toString());
        }

    }//GEN-LAST:event_jTablenoticiaMouseClicked

    private void jTablenoticiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablenoticiaKeyReleased
        if (jTablenoticia.getSelectedRow() != -1) {
            txtcodigonoticia.setText(jTablenoticia.getValueAt(jTablenoticia.getSelectedRow(), 0).toString());
            txttitulonoticia.setText(jTablenoticia.getValueAt(jTablenoticia.getSelectedRow(), 1).toString());
            txtdescricaonoticia.setText(jTablenoticia.getValueAt(jTablenoticia.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_jTablenoticiaKeyReleased

    private void btneditarnoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarnoticiaActionPerformed
        if (jTablenoticia.getSelectedRow() != -1) {
            if (txttitulonoticia.getText().equals("") || txtdescricaonoticia.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha o titulo e/ou descricao.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
            } else {
                noticia n = new noticia();
                noticiadao dao = new noticiadao();
                n.setTitulo(txttitulonoticia.getText());
                n.setDescricao(txtdescricaonoticia.getText());
                n.setCodigo((int) jTablenoticia.getValueAt(jTablenoticia.getSelectedRow(), 0));
                dao.editar(n);
                limparnoticia();
                visualizarnoticia();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende editar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btneditarnoticiaActionPerformed

    private void btnapagarnoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarnoticiaActionPerformed
        if (jTablenoticia.getSelectedRow() != -1) {
            noticia n = new noticia();
            noticiadao dao = new noticiadao();
            n.setCodigo((int) jTablenoticia.getValueAt(jTablenoticia.getSelectedRow(), 0));
            dao.apagar(n);
            limparnoticia();
            visualizarnoticia();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende apagar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnapagarnoticiaActionPerformed

    private void btnprocurarnoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarnoticiaActionPerformed
        if (txtcodigonoticia.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            int c = Integer.parseInt(txtcodigonoticia.getText());
            procurarnoticia(c);
        }
    }//GEN-LAST:event_btnprocurarnoticiaActionPerformed

    private void btnautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnautoridadeActionPerformed
        autoridade.setVisible(true);
        noticia.setVisible(false);
        navio.setVisible(false);
        responsavel.setVisible(false);
        mercadoria.setVisible(false);
        comboio.setVisible(false);
        camiao.setVisible(false);
        usuario.setVisible(false);
        btnfechar.setVisible(true);
    }//GEN-LAST:event_btnautoridadeActionPerformed

    private void txttelefoneautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefoneautoridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefoneautoridadeActionPerformed

    private void txtemailautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailautoridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailautoridadeActionPerformed

    private void txtnupautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnupautoridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnupautoridadeActionPerformed

    private void btnlimparautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparautoridadeActionPerformed
        limparautoridade();
        visualizarautoridade();
    }//GEN-LAST:event_btnlimparautoridadeActionPerformed

    private void btnrecontratarautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecontratarautoridadeActionPerformed
        if (jTableautoridade.getSelectedRow() != -1) {
            autoridade a = new autoridade();
            autoridadedao dao = new autoridadedao();
            a.setCargo("at");
            a.setCodigo((int) jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 0));
            dao.despedido(a);
            limparautoridade();
            visualizarautoridade();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende recontratar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnrecontratarautoridadeActionPerformed

    private void btncadastrarautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarautoridadeActionPerformed
        if (txtnomeautoridade.getText().equals("") || txtemailautoridade.getText().equals("") || txtenderecoautoridade.getText().equals("") || txttelefoneautoridade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o campo em branco.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {

            autoridade a = new autoridade();
            autoridadedao dao = new autoridadedao();
            a.setNome(txtnomeautoridade.getText());
            a.setTelefone(Integer.parseInt(txttelefoneautoridade.getText()));
            a.setEmail(txtemailautoridade.getText());
            a.setEndereco(txtenderecoautoridade.getText());
            a.setCargo(cbocargoautoridade.getSelectedItem().toString());
            try {
                dao.cadastrar(a);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            limparautoridade();
            visualizarautoridade();
        }
    }//GEN-LAST:event_btncadastrarautoridadeActionPerformed

    private void jTableautoridadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableautoridadeMouseClicked
        if (jTableautoridade.getSelectedRow() != -1) {
            txtnupautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 0).toString());
            txtnomeautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 1).toString());
            txttelefoneautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 2).toString());
            txtemailautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 3).toString());
            txtenderecoautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 4).toString());
            cbocargoautoridade.setSelectedItem(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTableautoridadeMouseClicked

    private void btnprocurarautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarautoridadeActionPerformed
        if (txtnupautoridade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        } else {
            int c = Integer.parseInt(txtnupautoridade.getText());
            procurarautoridade(c);
        }
    }//GEN-LAST:event_btnprocurarautoridadeActionPerformed

    private void btneditarautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarautoridadeActionPerformed
        if (jTableautoridade.getSelectedRow() != -1) {
            if (txtnomeautoridade.getText().equals("") || txtemailautoridade.getText().equals("") || txtenderecoautoridade.getText().equals("") || txttelefoneautoridade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha o campo em branco.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
            } else {
                autoridade a = new autoridade();
                autoridadedao dao = new autoridadedao();
                a.setNome(txtnomeautoridade.getText());
                a.setTelefone(Integer.parseInt(txttelefoneautoridade.getText()));
                a.setEmail(txtemailautoridade.getText());
                a.setEndereco(txtenderecoautoridade.getText());
                a.setCargo(cbocargoautoridade.getSelectedItem().toString());
                a.setCodigo((int) jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 0));
                try {
                    dao.editar(a);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparautoridade();
                visualizarautoridade();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende editar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btneditarautoridadeActionPerformed

    private void btnfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfecharActionPerformed
        noticia.setVisible(false);
        autoridade.setVisible(false);
        navio.setVisible(false);
        responsavel.setVisible(false);
        mercadoria.setVisible(false);
        comboio.setVisible(false);
        camiao.setVisible(false);
        usuario.setVisible(false);
        btnfechar.setVisible(false);
    }//GEN-LAST:event_btnfecharActionPerformed

    private void btndespedirautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndespedirautoridadeActionPerformed
        if (jTableautoridade.getSelectedRow() != -1) {
            autoridade a = new autoridade();
            autoridadedao dao = new autoridadedao();
            a.setCargo(0+"");
            a.setCodigo((int) jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 0));
            dao.despedido(a);
            limparautoridade();
            visualizarautoridade();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende despedir.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btndespedirautoridadeActionPerformed

    private void jTableautoridadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableautoridadeKeyReleased
        if (jTableautoridade.getSelectedRow() != -1) {
            txtnupautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 0).toString());
            txtnomeautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 1).toString());
            txttelefoneautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 2).toString());
            txtemailautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 3).toString());
            txtenderecoautoridade.setText(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 4).toString());
            cbocargoautoridade.setSelectedItem(jTableautoridade.getValueAt(jTableautoridade.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTableautoridadeKeyReleased

    private void btncamiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncamiaoActionPerformed
        camiao.setVisible(true);
        noticia.setVisible(false);
        autoridade.setVisible(false);
        navio.setVisible(false);
        responsavel.setVisible(false);
        comboio.setVisible(false);
        usuario.setVisible(false);
        btnfechar.setVisible(true);
    }//GEN-LAST:event_btncamiaoActionPerformed

    private void btnnavioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnavioActionPerformed
        navio.setVisible(true);
        autoridade.setVisible(false);
        noticia.setVisible(false);
        responsavel.setVisible(false);
        mercadoria.setVisible(false);
        comboio.setVisible(false);
        camiao.setVisible(false);
        usuario.setVisible(false);
        btnfechar.setVisible(true);
    }//GEN-LAST:event_btnnavioActionPerformed

    private void txtnupnavioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnupnavioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnupnavioActionPerformed

    private void btnprocurarnavioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarnavioActionPerformed
        if (txtnupnavio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        } else {
            int c = Integer.parseInt(txtnupnavio.getText());
            procurarnavio(c);
        }
    }//GEN-LAST:event_btnprocurarnavioActionPerformed

    private void jTablenavioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablenavioMouseClicked
        if (jTablenavio.getSelectedRow() != -1) {
            txtnupnavio.setText(jTablenavio.getValueAt(jTablenavio.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTablenavioMouseClicked

    private void jTablenavioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablenavioKeyReleased
        if (jTablenavio.getSelectedRow() != -1) {
            txtnupnavio.setText(jTablenavio.getValueAt(jTablenavio.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTablenavioKeyReleased

    private void btncancelarchegadanavioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarchegadanavioActionPerformed
        if (jTablenavio.getSelectedRow() != -1) {
            navio na = new navio();
            naviodao nadao = new naviodao();
            na.setPassageiros(0);
            na.setChegada("0000-00-00");
            na.setPartida("0000-00-00");
            na.setCodigo((int) jTablenavio.getValueAt(jTablenavio.getSelectedRow(), 0));
            nadao.cancelarchegada(na);
            limparnavio();
            visualizarnavio();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende cancelar a chegada.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btncancelarchegadanavioActionPerformed

    private void btncancelarpartidanavioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarpartidanavioActionPerformed
        if (jTablenavio.getSelectedRow() != -1) {
            navio na = new navio();
            naviodao nadao = new naviodao();
            na.setPassageiros(0);
            na.setPartida("0000-00-00");
            na.setCodigo((int) jTablenavio.getValueAt(jTablenavio.getSelectedRow(), 0));
            nadao.cancelarpartida(na);
            limparnavio();
            visualizarnavio();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende cancelar a partida.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btncancelarpartidanavioActionPerformed

    private void btnapagarnavioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarnavioActionPerformed
        if (jTablenavio.getSelectedRow() != -1) {
            navio na = new navio();
            naviodao nadao = new naviodao();
            na.setCodigo((int) jTablenavio.getValueAt(jTablenavio.getSelectedRow(), 0));
            nadao.apagar(na);
            limparnavio();
            visualizarnavio();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende apagar.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnapagarnavioActionPerformed

    private void btnresponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresponsavelActionPerformed
        responsavel.setVisible(true);
        noticia.setVisible(false);
        autoridade.setVisible(false);
        navio.setVisible(false);
        mercadoria.setVisible(false);
        comboio.setVisible(false);
        camiao.setVisible(false);
        usuario.setVisible(false);
        btnfechar.setVisible(true);
    }//GEN-LAST:event_btnresponsavelActionPerformed

    private void btnprocurarresponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarresponsavelActionPerformed
        if (txtnupresponsavel.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        } else {
            int c = Integer.parseInt(txtnupresponsavel.getText());
            procurarresponsavel(c);
        }
    }//GEN-LAST:event_btnprocurarresponsavelActionPerformed

    private void btnapagarresponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarresponsavelActionPerformed
        if (jTableresponsavel.getSelectedRow() != -1) {
            responsavel r = new responsavel();
            responsaveldao rdao = new responsaveldao();
            r.setCodigo((int) jTableresponsavel.getValueAt(jTableresponsavel.getSelectedRow(), 0));
            rdao.apagar(r);
            limparresponsavel();
            visualizarresponsavel();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende apagar.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnapagarresponsavelActionPerformed

    private void jTableresponsavelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableresponsavelKeyReleased
        if (jTableresponsavel.getSelectedRow() != -1) {
            txtnupresponsavel.setText(jTableresponsavel.getValueAt(jTableresponsavel.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTableresponsavelKeyReleased

    private void jTableresponsavelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableresponsavelMouseClicked
        if (jTableresponsavel.getSelectedRow() != -1) {
            txtnupresponsavel.setText(jTableresponsavel.getValueAt(jTableresponsavel.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTableresponsavelMouseClicked

    private void btnlimparresponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparresponsavelActionPerformed
        limparresponsavel();
        visualizarresponsavel();
    }//GEN-LAST:event_btnlimparresponsavelActionPerformed

    private void btnlimparnavioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparnavioActionPerformed
        limparnavio();
        visualizarnavio();
    }//GEN-LAST:event_btnlimparnavioActionPerformed

    private void btnatracarnavioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatracarnavioActionPerformed
        if (jTablenavio.getSelectedRow() != -1) {
            navio na = new navio();
            naviodao nadao = new naviodao();
            na.setCodigo((int) jTablenavio.getValueAt(jTablenavio.getSelectedRow(), 0));
            nadao.atracar(na);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende atracar.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnatracarnavioActionPerformed

    private void txtnupcamiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnupcamiaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnupcamiaoActionPerformed

    private void jTablecamiaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablecamiaoKeyReleased
        if (jTablecamiao.getSelectedRow() != -1) {
            txtnupcamiao.setText(jTablecamiao.getValueAt(jTablecamiao.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTablecamiaoKeyReleased

    private void jTablecamiaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablecamiaoMouseClicked
        if (jTablecamiao.getSelectedRow() != -1) {
            txtnupcamiao.setText(jTablecamiao.getValueAt(jTablecamiao.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTablecamiaoMouseClicked

    private void btnprocurarcamiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarcamiaoActionPerformed
        if (txtnupcamiao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        } else {
            int c = Integer.parseInt(txtnupcamiao.getText());
            procurarcamiao(c);
        }
    }//GEN-LAST:event_btnprocurarcamiaoActionPerformed

    private void btnlimparcamiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparcamiaoActionPerformed
        limparcamiao();
        visualizarcamiao();
    }//GEN-LAST:event_btnlimparcamiaoActionPerformed

    private void btnapagarcamiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarcamiaoActionPerformed
        if (jTablecamiao.getSelectedRow() != -1) {
            camiao cm = new camiao();
            camiaodao cmdao = new camiaodao();
            cm.setCodigo((int) jTablecamiao.getValueAt(jTablecamiao.getSelectedRow(), 0));
            cmdao.apagar(cm);
            limparcamiao();
            visualizarcamiao();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende apagar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnapagarcamiaoActionPerformed

    private void btncancelarchegadacamiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarchegadacamiaoActionPerformed
        if (jTablecamiao.getSelectedRow() != -1) {
            camiao cm = new camiao();
            camiaodao cmdao = new camiaodao();
            cm.setPassageiros(0);
            cm.setChegada("0000-00-00");
            cm.setCodigo((int) jTablecamiao.getValueAt(jTablecamiao.getSelectedRow(), 0));
            cmdao.cancelarchegada(cm);
            limparcamiao();
            visualizarcamiao();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende cancelar a chegada.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btncancelarchegadacamiaoActionPerformed

    private void btncomboioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomboioActionPerformed
        comboio.setVisible(true);
        noticia.setVisible(false);
        autoridade.setVisible(false);
        navio.setVisible(false);
        responsavel.setVisible(false);
        mercadoria.setVisible(false);
        camiao.setVisible(false);
        usuario.setVisible(false);
        btnfechar.setVisible(true);
    }//GEN-LAST:event_btncomboioActionPerformed

    private void btnapagarcomboioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarcomboioActionPerformed
        if (jTablecomboio.getSelectedRow() != -1) {
            comboio cb = new comboio();
            comboiodao cbdao = new comboiodao();
            cb.setCodigo((int) jTablecomboio.getValueAt(jTablecomboio.getSelectedRow(), 0));
            cbdao.apagar(cb);
            limparcomboio();
            visualizarcomboio();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende apagar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnapagarcomboioActionPerformed

    private void btnprocurarcomboioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarcomboioActionPerformed
        if (txtnupcomboio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        } else {
            int c = Integer.parseInt(txtnupcomboio.getText());
            procurarcomboio(c);
        }
    }//GEN-LAST:event_btnprocurarcomboioActionPerformed

    private void btncancelarchegadacomboioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarchegadacomboioActionPerformed
        if (jTablecomboio.getSelectedRow() != -1) {
            comboio cb = new comboio();
            comboiodao cbdao = new comboiodao();
            cb.setPassageiros(0);
            cb.setChegada("0000-00-00");
            cb.setPartida("0000-00-00");
            cb.setCodigo((int) jTablecomboio.getValueAt(jTablecomboio.getSelectedRow(), 0));
            cbdao.cancelarchegada(cb);
            limparcomboio();
            visualizarcomboio();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende cancelar a chegada.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btncancelarchegadacomboioActionPerformed

    private void btnlimparcomboioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparcomboioActionPerformed
        limparcomboio();
        visualizarcomboio();
    }//GEN-LAST:event_btnlimparcomboioActionPerformed

    private void btncancelarpartidacomboioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarpartidacomboioActionPerformed
        if (jTablecomboio.getSelectedRow() != -1) {
            comboio cb = new comboio();
            comboiodao cbdao = new comboiodao();
            cb.setPassageiros(0);
            cb.setPartida("0000-00-00");
            cb.setCodigo((int) jTablecomboio.getValueAt(jTablecomboio.getSelectedRow(), 0));
            cbdao.cancelarpartida(cb);
            limparcomboio();
            visualizarcomboio();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende cancelar a partida.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btncancelarpartidacomboioActionPerformed

    private void jTablecomboioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablecomboioKeyReleased
        if (jTablecomboio.getSelectedRow() != -1) {
            txtnupcomboio.setText(jTablecomboio.getValueAt(jTablecomboio.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTablecomboioKeyReleased

    private void jTablecomboioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablecomboioMouseClicked
        if (jTablecomboio.getSelectedRow() != -1) {
            txtnupcomboio.setText(jTablecomboio.getValueAt(jTablecomboio.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTablecomboioMouseClicked

    private void btnmercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmercadoriaActionPerformed
        mercadoria.setVisible(true);
        noticia.setVisible(false);
        autoridade.setVisible(false);
        navio.setVisible(false);
        responsavel.setVisible(false);
        comboio.setVisible(false);
        camiao.setVisible(false);
        usuario.setVisible(false);
        btnfechar.setVisible(true);
    }//GEN-LAST:event_btnmercadoriaActionPerformed

    private void jTablecaminhoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablecaminhoKeyReleased
        if (jTablecaminho.getSelectedRow() != -1) {
            txtcodigocaminho.setText(jTablecaminho.getValueAt(jTablecaminho.getSelectedRow(), 0).toString());
            txteditarresponsavelcaminho.setText(jTablecaminho.getValueAt(jTablecaminho.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTablecaminhoKeyReleased

    private void jTablecaminhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablecaminhoMouseClicked
        if (jTablecaminho.getSelectedRow() != -1) {
            txtcodigocaminho.setText(jTablecaminho.getValueAt(jTablecaminho.getSelectedRow(), 0).toString());
            txteditarresponsavelcaminho.setText(jTablecaminho.getValueAt(jTablecaminho.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTablecaminhoMouseClicked

    private void btnprocurarcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarcaminhoActionPerformed
        if (txtcodigocaminho.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            int c = Integer.parseInt(txtcodigocaminho.getText());
            procurarcaminho(c);
        }
    }//GEN-LAST:event_btnprocurarcaminhoActionPerformed

    private void btnlimparcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparcaminhoActionPerformed
        limparcaminho();
    }//GEN-LAST:event_btnlimparcaminhoActionPerformed

    private void btnapagarcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarcaminhoActionPerformed
        if (jTablecaminho.getSelectedRow() != -1) {
            mercadoria mr = new mercadoria();
            mercadoriadao dao = new mercadoriadao();
            mr.setCodigo((int) jTablecaminho.getValueAt(jTablecaminho.getSelectedRow(), 0));
            dao.apagar(mr);
            limparcaminho();
            visualizarcaminho();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende apagar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnapagarcaminhoActionPerformed

    private void btneditarresponsavelcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarresponsavelcaminhoActionPerformed
        if (jTablecaminho.getSelectedRow() != -1) {
            if (txteditarresponsavelcaminho.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha o Codigo de Responsavel.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
            } else {
                mercadoria mr = new mercadoria();
                mercadoriadao dao = new mercadoriadao();
                mr.setResponsavel(Integer.parseInt(txteditarresponsavelcaminho.getText()));
                mr.setCodigo((int) jTablecaminho.getValueAt(jTablecaminho.getSelectedRow(), 0));
                try {
                    dao.editarresponsavel(mr);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparcaminho();
                visualizarcaminho();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende editar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btneditarresponsavelcaminhoActionPerformed

    private void btnprocuraratracadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocuraratracadoActionPerformed
        if (txtcodigoatracado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            int c = Integer.parseInt(txtcodigoatracado.getText());
            procuraratracado(c);
        }
    }//GEN-LAST:event_btnprocuraratracadoActionPerformed

    private void btneditarresponsavelatracadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarresponsavelatracadoActionPerformed
        if (jTableatracado.getSelectedRow() != -1) {
            if (txteditarresponsavelatracado.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha o Codigo de Responsavel.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
            } else {
                mercadoria mr = new mercadoria();
                mercadoriadao dao = new mercadoriadao();
                mr.setResponsavel(Integer.parseInt(txteditarresponsavelatracado.getText()));
                mr.setCodigo((int) jTableatracado.getValueAt(jTableatracado.getSelectedRow(), 0));
                try {
                    dao.editarresponsavel(mr);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparatracado();
                visualizaratracado();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende editar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btneditarresponsavelatracadoActionPerformed

    private void btnapagaratracadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagaratracadoActionPerformed
        if (jTableatracado.getSelectedRow() != -1) {
            mercadoria mr = new mercadoria();
            mercadoriadao dao = new mercadoriadao();
            mr.setCodigo((int) jTableatracado.getValueAt(jTableatracado.getSelectedRow(), 0));
            dao.apagar(mr);
            limparatracado();
            visualizaratracado();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende apagar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnapagaratracadoActionPerformed

    private void btnlimparatracadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparatracadoActionPerformed
        limparatracado();
    }//GEN-LAST:event_btnlimparatracadoActionPerformed

    private void jTableatracadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableatracadoMouseClicked
        if (jTableatracado.getSelectedRow() != -1) {
            txtcodigoatracado.setText(jTableatracado.getValueAt(jTableatracado.getSelectedRow(), 0).toString());
            txteditarresponsavelatracado.setText(jTableatracado.getValueAt(jTableatracado.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTableatracadoMouseClicked

    private void jTableatracadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableatracadoKeyReleased
        if (jTableatracado.getSelectedRow() != -1) {
            txtcodigoatracado.setText(jTableatracado.getValueAt(jTableatracado.getSelectedRow(), 0).toString());
            txteditarresponsavelatracado.setText(jTableatracado.getValueAt(jTableatracado.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTableatracadoKeyReleased

    private void jTablearmazemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablearmazemMouseClicked
        if (jTablearmazem.getSelectedRow() != -1) {
            txtcodigoarmazem.setText(jTablearmazem.getValueAt(jTablearmazem.getSelectedRow(), 0).toString());
            txteditarresponsavelarmazem.setText(jTablearmazem.getValueAt(jTablearmazem.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTablearmazemMouseClicked

    private void jTablearmazemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablearmazemKeyReleased
        if (jTablearmazem.getSelectedRow() != -1) {
            txtcodigoarmazem.setText(jTablearmazem.getValueAt(jTablearmazem.getSelectedRow(), 0).toString());
            txteditarresponsavelarmazem.setText(jTablearmazem.getValueAt(jTablearmazem.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTablearmazemKeyReleased

    private void btnprocurarmazemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarmazemActionPerformed
        if (txtcodigoarmazem.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            int c = Integer.parseInt(txtcodigoarmazem.getText());
            procurararmazem(c);
        }
    }//GEN-LAST:event_btnprocurarmazemActionPerformed

    private void btneditarresponsavelarmazemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarresponsavelarmazemActionPerformed
        if (jTablearmazem.getSelectedRow() != -1) {
            if (txteditarresponsavelarmazem.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha o Codigo de Responsavel.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
            } else {
                mercadoria mr = new mercadoria();
                mercadoriadao dao = new mercadoriadao();
                mr.setResponsavel(Integer.parseInt(txteditarresponsavelarmazem.getText()));
                mr.setCodigo((int) jTablearmazem.getValueAt(jTablearmazem.getSelectedRow(), 0));
                try {
                    dao.editarresponsavel(mr);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                limpararmazem();
                visualizararmazem();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende editar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btneditarresponsavelarmazemActionPerformed

    private void btnapagararmazemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagararmazemActionPerformed
        if (jTablearmazem.getSelectedRow() != -1) {
            mercadoria mr = new mercadoria();
            mercadoriadao dao = new mercadoriadao();
            mr.setCodigo((int) jTablearmazem.getValueAt(jTablearmazem.getSelectedRow(), 0));
            dao.apagar(mr);
            limpararmazem();
            visualizararmazem();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende apagar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnapagararmazemActionPerformed

    private void btnlimpararmazemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpararmazemActionPerformed
        limpararmazem();
    }//GEN-LAST:event_btnlimpararmazemActionPerformed

    private void btnprocurdespachadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurdespachadaActionPerformed
        if (txtcodigodespachada.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            int c = Integer.parseInt(txtcodigodespachada.getText());
            procurardespachada(c);
        }
    }//GEN-LAST:event_btnprocurdespachadaActionPerformed

    private void btnlimpardespachadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpardespachadaActionPerformed
        limpardespachada();
    }//GEN-LAST:event_btnlimpardespachadaActionPerformed

    private void jTabledespachadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabledespachadaMouseClicked
        if (jTabledespachada.getSelectedRow() != -1) {
            txtcodigodespachada.setText(jTabledespachada.getValueAt(jTabledespachada.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTabledespachadaMouseClicked

    private void jTabledespachadaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabledespachadaKeyReleased
        if (jTabledespachada.getSelectedRow() != -1) {
            txtcodigodespachada.setText(jTabledespachada.getValueAt(jTabledespachada.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTabledespachadaKeyReleased

    private void btneditarresponsavelarmazem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarresponsavelarmazem1ActionPerformed
        if (jTablearmazem.getSelectedRow() != -1) {
            mercadoria mr = new mercadoria();
            mercadoriadao dao = new mercadoriadao();
            mr.setChegada("0000-00-00");
            mr.setPartida("0000-00-00");
            mr.setCodigo((int) jTablearmazem.getValueAt(jTablearmazem.getSelectedRow(), 0));
            dao.cancelarchegada(mr);
            limpararmazem();
            visualizararmazem();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende cancelar a chegada.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btneditarresponsavelarmazem1ActionPerformed

    private void btneditarresponsavelarmazem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarresponsavelarmazem2ActionPerformed
        if (jTablearmazem.getSelectedRow() != -1) {

            mercadoria mr = new mercadoria();
            mercadoriadao dao = new mercadoriadao();
            mr.setCodigo((int) jTablearmazem.getValueAt(jTablearmazem.getSelectedRow(), 0));
            try {
                dao.apreender(mr);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpararmazem();
            visualizararmazem();

        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende editar.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btneditarresponsavelarmazem2ActionPerformed

    private void btnprocurapreendidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurapreendidaActionPerformed
        if (txtcodigoapreendida.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            int c = Integer.parseInt(txtcodigoapreendida.getText());
            procurarapreendida(c);
        }
    }//GEN-LAST:event_btnprocurapreendidaActionPerformed

    private void btnlimparapreendidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparapreendidaActionPerformed
        limparapreendida();
    }//GEN-LAST:event_btnlimparapreendidaActionPerformed

    private void jTableapreendidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableapreendidaMouseClicked
        if (jTableapreendida.getSelectedRow() != -1) {
            txtcodigoapreendida.setText(jTableapreendida.getValueAt(jTableapreendida.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTableapreendidaMouseClicked

    private void jTableapreendidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableapreendidaKeyReleased
        if (jTableapreendida.getSelectedRow() != -1) {
            txtcodigoapreendida.setText(jTableapreendida.getValueAt(jTableapreendida.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTableapreendidaKeyReleased

    private void txtcodigoapreendidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoapreendidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoapreendidaActionPerformed

    private void btnusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuarioActionPerformed
        usuario.setVisible(true);
        noticia.setVisible(false);
        autoridade.setVisible(false);
        navio.setVisible(false);
        responsavel.setVisible(false);
        mercadoria.setVisible(false);
        comboio.setVisible(false);
        camiao.setVisible(false);
        btnfechar.setVisible(true);
    }//GEN-LAST:event_btnusuarioActionPerformed

    private void txtnupusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnupusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnupusuarioActionPerformed

    private void btnlimparusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparusuarioActionPerformed
        limparusuario();
    }//GEN-LAST:event_btnlimparusuarioActionPerformed

    private void btncadastrarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarusuarioActionPerformed
        usuariodao dao = new usuariodao();
        int c = Integer.parseInt(cbonupusuario.getSelectedItem().toString());

        if (txtsenhausuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor digite a senha.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                if (dao.verificar(c, "at")) {

                    JOptionPane.showMessageDialog(null, "Este usuario ja tem acesso ao sistema.", "NUP incorrecto", JOptionPane.ERROR_MESSAGE);
                } else {
                    usuario u = new usuario();
                    u.setCodigo(Integer.parseInt((String) cbonupusuario.getSelectedItem()));
                    u.setsenha(txtsenhausuario.getText());
                    u.settipo("at");
                    dao.cadastrar(u);
                    limparusuario();
                    visualizarusuario();
                    visualizarcontrole();

                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btncadastrarusuarioActionPerformed

    private void btnprocurarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarusuarioActionPerformed
        if (txtnupusuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o codigo.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            int c = Integer.parseInt(txtnupusuario.getText());
            procurarusuario(c);
        }
    }//GEN-LAST:event_btnprocurarusuarioActionPerformed

    private void jTablecontroleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablecontroleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablecontroleMouseClicked

    private void jTablecontroleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablecontroleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablecontroleKeyReleased

    private void btneditarsenhausuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarsenhausuarioActionPerformed
        if (jTableusuario.getSelectedRow() != -1) {
            usuario u = new usuario();
            usuariodao udao = new usuariodao();
            u.setsenha(txtsenhausuario.getText());
            u.setCodigo((int) jTableusuario.getValueAt(jTableusuario.getSelectedRow(), 0));

            udao.editar(u);

            limparusuario();
            visualizarusuario();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione a linha que pretende editar a senha.", "Linha nao selecionada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btneditarsenhausuarioActionPerformed

    private void jTableusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableusuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableusuarioMouseClicked

    private void jTableusuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableusuarioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableusuarioKeyReleased

    private void cbocargoautoridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocargoautoridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbocargoautoridadeActionPerformed

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
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new admin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel apreendida;
    private javax.swing.JPanel armazem;
    private javax.swing.JPanel atracado;
    private javax.swing.JInternalFrame autoridade;
    private javax.swing.JButton btnapagararmazem;
    private javax.swing.JButton btnapagaratracado;
    private javax.swing.JButton btnapagarcamiao;
    private javax.swing.JButton btnapagarcaminho;
    private javax.swing.JButton btnapagarcomboio;
    private javax.swing.JButton btnapagarnavio;
    private javax.swing.JButton btnapagarnoticia;
    private javax.swing.JButton btnapagarresponsavel;
    private javax.swing.JButton btnatracarnavio;
    private javax.swing.JButton btnautoridade;
    private javax.swing.JButton btncadastrarautoridade;
    private javax.swing.JButton btncadastrarnoticia;
    private javax.swing.JButton btncadastrarusuario;
    private javax.swing.JButton btncamiao;
    private javax.swing.JButton btncancelarchegadacamiao;
    private javax.swing.JButton btncancelarchegadacomboio;
    private javax.swing.JButton btncancelarchegadanavio;
    private javax.swing.JButton btncancelarpartidacomboio;
    private javax.swing.JButton btncancelarpartidanavio;
    private javax.swing.JButton btncomboio;
    private javax.swing.JButton btndespedirautoridade;
    private javax.swing.JButton btneditarautoridade;
    private javax.swing.JButton btneditarnoticia;
    private javax.swing.JButton btneditarresponsavelarmazem;
    private javax.swing.JButton btneditarresponsavelarmazem1;
    private javax.swing.JButton btneditarresponsavelarmazem2;
    private javax.swing.JButton btneditarresponsavelatracado;
    private javax.swing.JButton btneditarresponsavelcaminho;
    private javax.swing.JButton btneditarsenhausuario;
    private javax.swing.JButton btnfechar;
    private javax.swing.JButton btnlimparapreendida;
    private javax.swing.JButton btnlimpararmazem;
    private javax.swing.JButton btnlimparatracado;
    private javax.swing.JButton btnlimparautoridade;
    private javax.swing.JButton btnlimparcamiao;
    private javax.swing.JButton btnlimparcaminho;
    private javax.swing.JButton btnlimparcomboio;
    private javax.swing.JButton btnlimpardespachada;
    private javax.swing.JButton btnlimparnavio;
    private javax.swing.JButton btnlimparnoticia;
    private javax.swing.JButton btnlimparresponsavel;
    private javax.swing.JButton btnlimparusuario;
    private javax.swing.JButton btnmercadoria;
    private javax.swing.JButton btnnavio;
    private javax.swing.JButton btnnoticia;
    private javax.swing.JButton btnprocurapreendida;
    private javax.swing.JButton btnprocuraratracado;
    private javax.swing.JButton btnprocurarautoridade;
    private javax.swing.JButton btnprocurarcamiao;
    private javax.swing.JButton btnprocurarcaminho;
    private javax.swing.JButton btnprocurarcomboio;
    private javax.swing.JButton btnprocurarmazem;
    private javax.swing.JButton btnprocurarnavio;
    private javax.swing.JButton btnprocurarnoticia;
    private javax.swing.JButton btnprocurarresponsavel;
    private javax.swing.JButton btnprocurarusuario;
    private javax.swing.JButton btnprocurdespachada;
    private javax.swing.JButton btnrecontratarautoridade;
    private javax.swing.JButton btnresponsavel;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnusuario;
    private javax.swing.JInternalFrame camiao;
    private javax.swing.JPanel caminho;
    private javax.swing.JComboBox<String> cbocargoautoridade;
    private javax.swing.JComboBox<Object> cbonupusuario;
    private javax.swing.JInternalFrame comboio;
    private javax.swing.JPanel despachada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelfundo;
    private javax.swing.JLabel jLabellogo;
    private javax.swing.JPanel jPanelfundo;
    private javax.swing.JScrollPane jScrollPaneapreendida;
    private javax.swing.JScrollPane jScrollPanearmazem;
    private javax.swing.JScrollPane jScrollPaneatracado;
    private javax.swing.JScrollPane jScrollPaneautoridade;
    private javax.swing.JScrollPane jScrollPaneautoridade1;
    private javax.swing.JScrollPane jScrollPaneautoridade2;
    private javax.swing.JScrollPane jScrollPanecamiao;
    private javax.swing.JScrollPane jScrollPanecaminho;
    private javax.swing.JScrollPane jScrollPanecomboio;
    private javax.swing.JScrollPane jScrollPanedespachada;
    private javax.swing.JScrollPane jScrollPanenavio;
    private javax.swing.JScrollPane jScrollPanenoticia;
    private javax.swing.JScrollPane jScrollPaneresponsavel;
    private javax.swing.JSeparator jSeparatordivisao;
    private javax.swing.JTabbedPane jTabbedmercadoria;
    private javax.swing.JTable jTableapreendida;
    private javax.swing.JTable jTablearmazem;
    private javax.swing.JTable jTableatracado;
    private javax.swing.JTable jTableautoridade;
    private javax.swing.JTable jTablecamiao;
    private javax.swing.JTable jTablecaminho;
    private javax.swing.JTable jTablecomboio;
    private javax.swing.JTable jTablecontrole;
    private javax.swing.JTable jTabledespachada;
    private javax.swing.JTable jTablenavio;
    private javax.swing.JTable jTablenoticia;
    private javax.swing.JTable jTableresponsavel;
    private javax.swing.JTable jTableusuario;
    private javax.swing.JInternalFrame mercadoria;
    private javax.swing.JInternalFrame navio;
    private javax.swing.JInternalFrame noticia;
    private javax.swing.JInternalFrame responsavel;
    private javax.swing.JTextField txtcodigoapreendida;
    private javax.swing.JTextField txtcodigoarmazem;
    private javax.swing.JTextField txtcodigoatracado;
    private javax.swing.JTextField txtcodigocaminho;
    private javax.swing.JTextField txtcodigodespachada;
    private javax.swing.JTextField txtcodigonoticia;
    private javax.swing.JTextArea txtdescricaonoticia;
    private javax.swing.JTextField txteditarresponsavelarmazem;
    private javax.swing.JTextField txteditarresponsavelatracado;
    private javax.swing.JTextField txteditarresponsavelcaminho;
    private javax.swing.JTextField txtemailautoridade;
    private javax.swing.JTextField txtenderecoautoridade;
    private javax.swing.JTextField txtnomeautoridade;
    private javax.swing.JTextField txtnupautoridade;
    private javax.swing.JTextField txtnupcamiao;
    private javax.swing.JTextField txtnupcomboio;
    private javax.swing.JTextField txtnupnavio;
    private javax.swing.JTextField txtnupresponsavel;
    private javax.swing.JTextField txtnupusuario;
    private javax.swing.JPasswordField txtsenhausuario;
    private javax.swing.JTextField txttelefoneautoridade;
    private javax.swing.JTextField txttitulonoticia;
    private javax.swing.JInternalFrame usuario;
    // End of variables declaration//GEN-END:variables

}

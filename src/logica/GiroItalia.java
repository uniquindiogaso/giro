package logica;

/**
 * Esta clase es la encargada de manejar la informacion relevante del giro de
 * italia
 *
 * @author Admin
 * @version 1.0
 */
public class GiroItalia {

    private String annio;
    private Equipo[][] equipos;

    public GiroItalia(String annio) {
        this.annio = annio;
        equipos = new Equipo[5][5];
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public Equipo[][] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo[][] equipos) {
        this.equipos = equipos;
    }

    /**
     * Este método es el encargado de buscar un equipo en la matriz de todos los
     * equipos
     *
     * @param codigo codigo único que identifica el equipo
     * @return true si encontro el equipo de lo contrario retorna false
     */
    public boolean buscarEquipo(String codigo) {

        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos.length; j++) {
                if (equipos[i][j] != null) {
                    if (equipos[i][j].getCodigo().equals(codigo)) {
                        return true;
                    }

                }

            }
        }

        return false;
    }

    /**
     * Este metodo es el encargado de agregar un equipo a la matriz de todos los
     * equipos
     *
     * @param e equipo a agregar
     * @return true si el equipo fue agregardo de lo contrario reorna false
     */
    public boolean agregarEquipo(Equipo e) {
        //usar el metodo para buscar el equipo, si lo encuntra retorna false al tratar de agregar el equipo
        if (buscarEquipo(e.getCodigo())) {
            return false;
        }
        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos.length; j++) {
                if (equipos[i][j] == null) {

                    equipos[i][j] = e;
                    return true;
                }

            }

        }
        return false;
    }

    /**
     * este metodo se encarga de eliminar un equipo de la matriz de equipos
     *
     * @param codigo codigo unico que identifica al equipo
     * @return true si el equipo fue eliminado de lo contrario retorna false
     */
    public boolean eliminarEquipo(String codigo) {

        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos.length; j++) {
                if (equipos[i][j] != null || equipos[i][j].getCodigo().equals(codigo)) {
                    equipos[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Eliminar ciclista de Equipo
     *
     * @param codigoEquipo Codigo unico del Equipo al que pertenece el ciclista
     * @param id identificacion unica del ciclista a eliminar
     * @return verdadero si se elimina correctamente , falso sino
     */
    public boolean eliminarCiclista(String codigoEquipo, String id) {
        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos.length; j++) {
                if (equipos[i][j] != null && equipos[i][j].getCodigo().equals(codigoEquipo)) {
                    return equipos[i][j].eliminarCiclista(id);
                }

            }
        }
        return false;
    }

    /**
     * Buscar por codigo la ubicacion en el arreglo del equipo
     *
     * @param codigo codigo que identifica de manera unica al equipo
     * @return arreglo de posicion i,j donde esta ubicado el equipo o null si el
     * equipo no fue encontrado
     */
    public int[] ubicarEquipo(String codigo) {
        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos[i].length; j++) {
                if (equipos[i][j] != null && equipos[i][j].getCodigo().equals(codigo)) {
                    return new int[]{i, j};
                }

            }

        }
        return null;
    }

    /**
     * Agregar Ciclista a Equipo
     *
     * @param codigoEquipo Codigo unico del Equipo al que pertenece el ciclista
     * @param c Objeto completo con informacion del ciclista
     * @return true si fue posible agregarlo , false sino
     */
    public boolean agregarCiclista(String codigoEquipo, Ciclista c) {
        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos.length; j++) {
                if (equipos[i][j] != null && equipos[i][j].getCodigo().equals(codigoEquipo)) {
                    return equipos[i][j].agregarCiclista(c);
                }
            }
        }
        return false;
    }

    /**
     * Buscar equipo que contenga la mayor cantidad de ciclistas asignados
     *
     * @return Objeto de Tipo Equipo
     */
    public Equipo buscaEquipoMasCiclistas() {

        Equipo e = null;
        int max = 0;
        for (Equipo[] equipoI : equipos) {
            for (Equipo equipoJ : equipoI) {
                if (equipoJ != null) {
                    int ciclistas = equipoJ.contarCiclistas();
                    if (ciclistas > max) {
                        max = ciclistas;
                        e = equipoJ;
                    }
                }
            }
        }
        return e;
    }

    public Ciclista ciclistaMejorTiempo() {

        return null;
    }

    /**
     * Intercambiar Ciclita de dos Equipos
     *
     * @param cod1 Codigo unico del equipo 1
     * @param cod2 Codigo unico del equipo 2
     * @return true si se realizo el intercambio | false si no se logro realizar
     */
    public boolean intercambioCiclistasEquipo(String cod1, String cod2) {
        int[] a = ubicarEquipo(cod1);
        int[] b = ubicarEquipo(cod2);

        if (a == null || b == null) {
            return false;
        }

        Ciclista[] intercambio = equipos[a[0]][a[1]].getCiclistas();
        equipos[a[0]][a[1]].setCiclistas(equipos[b[0]][b[1]].getCiclistas());
        equipos[b[0]][b[1]].setCiclistas(intercambio);

        return true;

    }

    /**
     * Encuentra el ciclista con el mejor tiempo de los equipos del giro
     * @return objeto Ciclista o null si todos los equipos estan vacios
     */
    public Ciclista liderGiro() {

        Ciclista c = null;
        double mejor = Double.MAX_VALUE;

        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos[i].length; j++) {

                if (equipos[i][j] != null) {
                    double tiempo = equipos[i][j].liderEquipo().getTiempo();
                    if (tiempo < mejor) {
                        mejor = tiempo;
                        c = equipos[i][j].liderEquipo();
                    }
                }
            }
        }
        return c;
    }
    
    /**
     * Retorna el tiempo actualizado al adicionar el tiempo extra al ciclista buscado
     * @param tiempo tiempo a adicionar
     * @param numCiclista numero de camiseta del ciclista a buscar
     * @return tiempo actualizado del ciclista de lo contrario retorna -1 si no encontro el ciclista en ningun equipo
     */
    public double adicionarTiempoCiclista(double tiempo , int numCiclista){
        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos[i].length; j++) {
                if(equipos[i][j] != null){
                    Ciclista c = equipos[i][j].buscarPorNumero(numCiclista);
                    if(c != null){
                        c.setTiempo( c.getTiempo() + tiempo );                        
                        return c.getTiempo();
                    }
                }
            }
            
        }
        
        return -1;
    }
}

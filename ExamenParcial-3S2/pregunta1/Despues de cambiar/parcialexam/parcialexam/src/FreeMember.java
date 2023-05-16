public class FreeMember extends Member {
    public FreeMember(String nombre) {
        super(nombre);
    }
    @Override
    public void joinTournament() {

        System.out.println("Ha sido agregado al torneo");
    }
    //Este método rompe LSP
    @Override
    public void organizeTournament() {
        System.out.println("Usted no puede organizar torneos");
    }
}

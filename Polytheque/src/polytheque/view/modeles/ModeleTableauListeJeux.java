package polytheque.view.modeles;

import javax.swing.table.AbstractTableModel;

import polytheque.view.AffichageListeJeux;

/**
 * Classe permettant de modéliser la liste des jeux.
 * 
 * @author Johan Brunet
 */
@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
public class ModeleTableauListeJeux extends AbstractTableModel
{
	/**
	 * Les données des cellules.
	 */
	private Object[][] donnees;
	
	/**
	 * Les titres des colonnes.
	 */
	private String[] libelles;
	
	/**
	 * Création d'un modèle de tableau.
	 * 
	 * @param donnees
	 *            Des données.
	 * @param libelles
	 *            Des libellés.
	 */
	public ModeleTableauListeJeux(Object[][] donnees, String[] libelles)
	{
		this.donnees = donnees;
		this.libelles = libelles;
	}
	
	@Override
	public int getColumnCount()
	{
		return this.libelles.length;
	}
	
	@Override
	public int getRowCount()
	{
		return this.donnees.length;
	}
	
	@Override
	public Object getValueAt(int row, int col)
	{
		return this.donnees[row][col];
	}
	
	@Override
	public String getColumnName(int col)
	{
		return this.libelles[col];
	}
	
	@Override
	public Class getColumnClass(int col)
	{
		return this.donnees[0][col].getClass();
	}
	
	@Override
	public boolean isCellEditable(int row, int col)
	{
		int index;
		for (index = 0; index < this.libelles.length; index++){
			if (this.getColumnName(col).equals(AffichageListeJeux.LIBELLES[index])) {
				return false;
			}
		}
		return true;
	}
}

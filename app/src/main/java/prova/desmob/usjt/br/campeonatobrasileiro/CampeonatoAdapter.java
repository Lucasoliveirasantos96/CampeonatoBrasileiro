package prova.desmob.usjt.br.campeonatobrasileiro;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * Created by arqdsis on 29/09/2017.
 */

public class CampeonatoAdapter extends BaseAdapter implements SectionIndexer {
    private Campeonato[] campeonatos;
    private Activity activity;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public CampeonatoAdapter(Campeonato[] campeonatos, Activity activity) {
        this.campeonatos = campeonatos;
        this.activity = activity;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(campeonatos);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(campeonatos);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(campeonatos);
    }

    @Override
    public int getCount() {
        return campeonatos.length;
    }

    @Override
    public Object getItem(int position) {
        return campeonatos[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_time, parent, false);
            ImageView bandeira = (ImageView) view.findViewById(R.id.foto_camp);
            TextView nome = (TextView) view.findViewById(R.id.texto_nome_time);
            TextView detalhe = (TextView) view.findViewById(R.id.texto_detalhe_time);
            ViewHolder viewHolder = new ViewHolder(bandeira, nome, detalhe);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder)view.getTag();
        viewHolder.getNome().setText(campeonatos[position].getNome());
        viewHolder.getDetalhe().setText(String.format("região: %s - capital: %s",
                campeonatos[position].getRegiao(),
                campeonatos[position].getCapital()));
        Drawable drawable = Util.getDrawable(activity, campeonatos[position].getCodigo3().toLowerCase());
        if(drawable == null){
            drawable = activity.getDrawable(bandeira);
        }
        System.out.println(campeonatos[position].getNome());
        viewHolder.getBandeira().setImageDrawable(drawable);

        return view;
    }

    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}

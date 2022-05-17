package com.mycompany.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.FontImage;

import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import com.mycompany.entities.Order;
import com.mycompany.entities.datas;

import com.mycompany.services.OrderService;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class statForm_1 extends Form {
    Form current;
    public statForm_1(Form previous) {
        setTitle("Statics");
        this.getToolbar().addCommandToLeftBar("Back", null, (evt) -> {
            new HomeForm().showBack();
        });
        current =this;
        Resources res=UIManager.initFirstTheme("/theme");;
        //super.addSideMenu(res);
        //Image img = res.getImage("backk.png");
        // if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
        // img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        // }
        //ScaleImageLabel sl = new ScaleImageLabel(img);
        //sl.setUIID("BottomPad");
        //sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        //Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        //Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        //facebook.setTextPosition(BOTTOM);
        //twitter.setTextPosition(BOTTOM);
       /*
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                        GridLayout.encloseIn(3,
                                facebook,
                                FlowLayout.encloseCenter(
                                        new Label(res.getImage("sta.jpg"), "PictureWhiteBackgrond")),
                                twitter
                        )
                )
        ));*/
        setLayout(BoxLayout.y());
        double[] values = new double[]{12, 14, 11, 10};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.LTGRAY, ColorUtil.GREEN, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setLabelsTextSize(100);

        renderer.setLabelsColor(ColorUtil.BLACK);
        renderer.setLegendTextSize(100);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(false);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);


        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Form f = new Form("Budget", new BorderLayout());
        add( c);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }

    /**
     * Creates a renderer for the specified colors.
     */
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }
    /**
     * Builds a category series using the provided values.
     *
     * @param title the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        List<datas> Form = new ArrayList<>();
        ArrayList<Order> tsk= OrderService.getInstance().getAllOrders();

        for(Order form :tsk)
        {
            Form.add(new datas(0,  form.getId(),form.getRegion(),0));
        }
        for(datas stat :Form)
        {
            int t=0;
            for(Order abo :tsk)
            {
                if(stat.getId()==abo.getId())
                {
                    t++;
                    stat.setNbre(t);
                }

            }
        }
        int i=0;
        Collections.sort(Form);
        for (datas value : Form) {
            i++;
            if(i<4)
                series.add(value.getNom(), value.getNbre());
        }


        return series;
    }

    public Form createPieChartForm() {
        // Generate the values
        double[] values = new double[]{12, 14, 11, 10};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setLabelsTextSize(50);
        renderer.setLegendTextSize(60);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Form f = new Form("Budget", new BorderLayout());
        f.add(BorderLayout.CENTER, c);
        return f;

    }

}

package gpf.study.fe.component.fieldExtend;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;

import cell.cdao.IDao;
import cell.cdao.IDaoService;
import cell.gpf.adur.data.IFormMgr;
import cmn.anotation.ClassDeclare;
import fe.cmn.data.PairDto;
import fe.cmn.editor.SelectEditorQuerier;
import fe.cmn.editor.SelectEditorQuerierContext;
import fe.cmn.panel.PanelContext;
import gpf.adur.data.Form;
import gpf.adur.data.ResultSet;
import gpf.dc.fe.component.editor.TextSelectExtendQueryInterface;
import gpf.dc.fe.component.editor.TextSelectExtendSelector;
@ClassDeclare(label = "文本选项列表自定义选项查询类样例"
,what="演示如何实现文本选项列表的自定选项查询类"
, why = ""
, how = ""
,developer="裴硕"
,version = "1.0"
,createTime = "2025-02-27"
,updateTime = "2025-02-27")
public class StudyTextSelectExtendQuery implements TextSelectExtendQueryInterface{

    @Override
    public List<PairDto> querySelectItems(TextSelectExtendSelector component,SelectEditorQuerier querier, SelectEditorQuerierContext context) throws Exception {
        List<PairDto> resultList = new ArrayList<>();
        try (IDao dao = IDaoService.newIDao()) {
            IFormMgr formMgr = IFormMgr.get();
            ResultSet<Form> rs = formMgr.queryFormPageWithoutNesting(dao, "gpf.md.basic.StyleDefineDo", null, 1, 10);
            for (Form form : rs.getDataList()) {
                String code = form.getString("编号");
                String label = form.getString("标签");
                resultList.add(new PairDto(code, label));
            }
        }

        return resultList;

    }

    @Override
    public List<PairDto> filterSelectItems(TextSelectExtendSelector component,SelectEditorQuerier querier, SelectEditorQuerierContext context) throws Exception {
        return querySelectItems(component,querier, context);
    }

    @Override
    public List<PairDto> queryCurrentOption(TextSelectExtendSelector component,PanelContext context, String... currentOptionValue) throws Exception {
        List<PairDto> resultList = new ArrayList<>();
        IFormMgr formMgr = IFormMgr.get();
        try (IDao dao = IDaoService.newIDao()) {
            if (currentOptionValue != null && currentOptionValue.length > 0) {
                Cnd cnd = Cnd.NEW();
                cnd.where().andInStrArray(Form.Code, currentOptionValue);
                ResultSet<Form> rs = formMgr.queryFormPageWithoutNesting(dao, "gpf.md.basic.StyleDefineDo",
                        cnd, 1, 10);
                for (Form form : rs.getDataList()) {
                    String code = form.getString("编号");
                    String label = form.getString("标签");
                    resultList.add(new PairDto(code, label));
                }
            }


        }

        return resultList;
    }
}
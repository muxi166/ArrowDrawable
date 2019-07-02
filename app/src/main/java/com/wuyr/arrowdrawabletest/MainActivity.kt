package com.wuyr.arrowdrawabletest

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.act_main_view.*
import java.util.*

/**
 * @author wuyr
 * @github https://github.com/wuyr/ArrowDrawable
 * @since 2019-07-02 上午9:24
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main_view)
        initView()
    }

    private fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = ListAdapter(this, getRandomData(8).toMutableList())
        recyclerView.adapter = mAdapter
        refreshLayout.setOnRefreshListener {
            refreshLayout.postDelayed({
                it.finishRefresh(!resultSwitch.isChecked)
                if (!resultSwitch.isChecked) {
                    mAdapter.setData(*getRandomData(8))
                }
            }, durationBar.progress.toLong())
        }
        durationBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                duration.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private val random = Random()

    private fun getRandomData(count: Int) = Array(count) {
        data[random.nextInt(data.size)]
    }

    private val data = arrayOf(
        "落花满天蔽月光，借一杯附荐凤台上。帝女花带泪上香，愿丧生回谢爹娘。偷偷看，偷偷望，佢带泪带泪暗悲伤。我半带惊惶，怕驸马惜鸾凤配，不甘殉爱伴我临泉壤。\n《帝女花-香夭》",
        "冷冷雪蝶临梅岭，曲中弦断香销劫后城，此日红阁有谁个悼崇祯，我灯昏梦醒哭祭茶亭；钗分玉碎想殉身归幽冥，帝后遗骸谁愿领。碧血积荒径。\n《帝女花-庵遇》",
        "飘渺间往事如梦情难认。百劫重逢缘何埋旧姓，夫妻断了情，唉鸳鸯已定，烽烟已靖，我偷偷相试佢未吐真情令我惊。\n《帝女花-庵遇》",
        "贮泪已一年，封存叁百日，尽在今时放，泣诉别离情。昭仁劫后血痕鲜，可怜梦觉剩空筵。空悼落花，不见如花影，难招紫玉魂，难随黄鹤去，估不到维摩观，便是你驻香庭。避世情难长孤另，轻寒夜拥梦难成。往日翠拥诸为千人敬。今日更无一个可叮咛。\n《帝女花-相认》",
        "山残水剩痛兴亡，劫后重逢悲聚散。有梦回故苑，无泪哭余情。雨后帝花飘，我不死无以对先王，偷生更难以谢民百姓。不孝已难容，欺世更无可恕，我虽生人世上，但鬼录已登名。\n《帝女花-相认》",
        "拾釵人從絕塞歸，墜釵人已移情去，歸來空抱恨，此恨永難翻。八千里路夢遙遙，壩陵橋畔柳絲絲，恍見夢中人，招手迎郎返。驚見賣釵人，釵未斷時情已斷，未溫前夢夢先殘。胡不念花院盟香，胡不念柳驛攀條，胡不念臨歧曾共鴛鴦盞。也應念紫陌天緣，也應念紅閨美眷，更有盟心句，寫在烏絲闌。\n《紫钗记-吞钗拒婚》",
        "十郎喊句舊情淡，偷將紫釵空泣嘆，怨句負愛寡恩紅顏。夢斷香銷我痛不欲生，哭分飛釵燕不待我回還。吞釵寧玉碎。情已冷，郎決殉愛，願以死酬俗眼。\n《紫钗记-吞钗拒婚》",
        "霧月夜抱泣落紅，險些破碎了燈釵夢。喚魂句頻頻喚句，卿須記取再重逢。嘆病染芳軀不禁搖動，重似望夫山半欹帶病容。千般話猶在未語中，深驚燕好皆變空。\n《紫钗记-剑合钗圆》",
        "處處仙音飄飄送，暗驚夜臺露凍。愁共怨待向陰司控，聽風吹翠竹，昏燈照影印簾櫳。霧夜少東風，誰嗰扶飛柳絮？\n《紫钗记-剑合钗圆》",
        "聞鐘鼓，郎就鳳凰筵，橫來白羽穿心箭，酸得我芳心碎盡步顛連。女子由來心眼淺，那禁她，金枝玉葉年年月月，依戀伴郎眠？妒酸風，怒滿了桃花雙臉。\n《紫钗记-节镇宣恩》",
        "茫茫烟水觅芳踪，浅笑轻颦常入梦。烟疑粉坠，水像脂融，似叶扁舟幸得风吹送，喜见锦帆斜挂夕阳中，我是彩云卿是凤。今日天台有路，莫教雾蔽烟笼。虽是萍水相交，何忍化秋云春梦。\n《再世红梅记-观柳还琴》",
        "嫩柳藏玉燕，梦徊尚忆拜裙前，有缘万里丝能牵，何幸再相见。兰心几回暗忖，莫非错入东邻别苑？绣户遥，花径短，惊初见宋玉少年，宁不腼腆。\n《再世红梅记-折梅巧遇》",
        "褪色桐棺露芳名，灯灭半浮纤丽影，疑是芳魂回柳舍，却缘是竹影乱花台，拜一拜棺中睡美人，避一避泉台新鬼恨，莫言咫尺是芳邻，须知阴阳如隔海。\n《再世红梅记-环佩魂归》",
        "花魁恨，一语恼孤鸾。赏灯谁断风筝线，盘秋谁断并头莲。有千金难买还魂券，秋灯灭，难以再重燃。摧花负罪你当难免。\n《蝶影红梨记-宦游三错》",
        "驚見閨秀桃紅暗泛。好似天際玄娘變幻。一笑回眸遞送秋波冷。託生風月壇。不差一絲間，定是玄女偷偷降落降落世間。化春鶯柳巷憐翠雁。失去廟堂夢裡顏，我夢覺常自嘆，痛泣孤單。\n《九天玄女》",
        "欲把舊調重複唱，弦驟斷難續上，碧天雲淡雨寒，天幡布陣有胭脂將，不納這癡心漢，憶倩女同墜愛網，登仙百念全喪，雙仙斜立兩旁，咫尺不願看，厭倦了塵俗相，化玄女依歸太上，塵俗客為你甘殉葬，曾付了相思賬，火劫鴛鴦，深深揖拜眾仙要念我狂。\n《九天玄女-於歸》",
        "不见风雨魂兮夜半还，红楼残梦断，黄竹血迹斑。痴情误，怎料到接木移花害了绝代颜。痛惜枉有天生宋玉才，叹未能唤魄返，欲上天阙，再落泉下探，秋雨春风梦到潇湘冷，悼翠悲红情泪染花瓣，葬花人难留俗眼，生死不了情永在世间，未许化烟消云散。\n《红楼梦-幻觉离恨天》",
        "三千风雨满仙山，隐约现情帆。爱深渐疏淡任风吹散。绾结三生一朝分散。红楼孽满，梦己断厌尘寰。剩有泪痕，付与鹃雁。魂在故园，暂寄潇湘不散。看宝玉痛孤单，惨切唤魂还，天宫泣幽咽，人间空嗟叹。往事应了，爱恨怕翻。弦断再续，也觉空泛。\n《红楼梦-幻觉离恨天》",
        "乘龙夜醉挽嫦娥拜，再续断钗，不须惊恐怕浪怕风，残庐结婚越觉情浓。龙凤有烛，奴实有福，秋波偷偷送。虽四壁皆空，夫妻居于破巢亦胜深宫。\n《跨凤乘龙-鸾凤同巢》",
        "十万横磨剑，宛似在目前，万众投鞭流可断，总不枉圣上归为臣虏强图存。当日申包胥，也遂存楚愿，深冀江南俊彦胜前贤。复国心急如弦上箭，壮怀激烈扣心弦。江南锦绣好江山，难容黩武穷兵占。\n《李后主-去国归降》",
        "花逐雨中飘，曲随广陵散。感时知有恨，惜别悄无言。一身能负几重忧，人间没处可安排，念往事合应肠断。冷雨送斜阳，问几许兴亡恨，怕从野叟话桑田。如此好江山，别时容易见时难，回首依依无限怨。\n《李后主-去国归降》",
        "烟波江上使人愁，眼前尽是遗民泪，怕牵衣泣血问归旋。江山依然，痛皇业变迁。此去囚居宋土，难卜再复旋。不知哪一天，不知哪一天，复我山川。相看倍心酸，难禁丝丝血泪垂 偷眼望宋船 撩乱了方寸。广陵台殿已荒凉 吴苑宫帏今冷落 剩一程风雨送愁人 叹千里江山寒色远。\n《李后主-去国归降》",
        "这才是人生难预料，不想团圆在今朝。回首繁华如梦渺，残生一线付惊涛。柳暗花明休啼笑，善果心花可自豪。种福得福如此报，愧我当初赠木桃。\n《锁麟囊-大团圆》",
        "风萧萧惯长征千里战马，高耸耸峻山岭又无人家，顾不得那路崎岖忙催战马。行来在歧路口，路现双岔\n《双阳公主》",
        "恨徐氏生嫉妒将我谋害，叹夫君通经纶识礼义，全不念结发夫妻情，他不该听信那枕边言，苦害我糟糠为何来？老天爷呀！多亏了小寿春闻风讯快，拯救我逃活命免遭祸灾。黑夜间路漫漫不识所在。\n《乾坤福寿镜》",
        "猛听得金鼓响画角声震，唤起我破天门壮志凌云。想当年桃花马上威风凛凛，敌血飞溅石榴裙。有生之日责当尽，寸土怎能属他人。番王小丑何足论，我一剑能挡百万兵！\n《穆桂英挂帅》",
        "听他言吓得我浑身是汗，十五载到今日才吐真言。原来是杨家将把名姓改换，他思家乡想骨肉就不得团圆。我这里走向前再把礼见。\n《四郎探母-坐宫》",
        "苏三离了洪洞县，将身来在大街前。未曾开言我心好惨，过往的君子听我言，哪一位去往南京转，与我那三郎把信传。就说苏三把命断，来生变犬马我当报还。\n《苏三起解》",
        "叫张生隐藏在棋盘之下，我步步行来你步步爬。放大胆忍气吞声休害伯，跟随着小红娘你就能见着她，可算得是一段风流佳话，听号令且莫要惊动了她。\n《红娘》",
        "这兄妹本是夫人话，只怨那张生一念差。说什么待月西厢下，你乱猜诗谜学偷花。果然是色胆比天大，夤夜深入闺阁家。若打官司当贼拿，用板子打来夹棍夹，游街示众你还戴枷。姑念你无知初犯法，看奴的薄面你就饶恕了他。\n《红娘》",
        "海岛冰轮初转腾，见玉兔，玉兔又早东升。那冰轮离海岛，乾坤分外明，皓月当空，恰便似嫦娥离月宫，奴似嫦娥离月宫，好一似嫦娥下九重。\n《贵妃醉酒》",
        "刘大哥讲话理太偏，谁说女子享清闲。男子打仗在边关，女子纺织在家园，白天去种地，夜晚来纺棉，不分昼夜辛勤把活干，将士们才能有这吃和穿。\n《花木兰》"
    )
}
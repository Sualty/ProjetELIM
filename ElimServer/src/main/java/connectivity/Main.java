package connectivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by blou on 29/01/17.
 */
public class Main {

    public static void main(String args[]) {
 /*       MyWeberver myWeberver = new MyWeberver();
        String result = "{\"dateToday\":\"2017 Fev 16 17:09:30\",\"id\":\"e4a4cf5e373af673\",\"value\":[{\"_id\":\"1\",\"kind\":\"IU\",\"day\":\"2017 janv. 29 20:14:09\"},{\"_id\":\"2\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 10:33:14\"},{\"_id\":\"3\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 10:34:05\"},{\"_id\":\"4\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 10:34:05\"},{\"_id\":\"5\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 10:34:06\"},{\"_id\":\"6\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 10:34:06\"},{\"_id\":\"7\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 10:54:15\"},{\"_id\":\"8\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 10:54:16\"},{\"_id\":\"9\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 11:15:45\"},{\"_id\":\"10\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 11:15:46\"},{\"_id\":\"11\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:27:10\"},{\"_id\":\"12\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:27:11\"},{\"_id\":\"13\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 11:28:35\"},{\"_id\":\"14\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 11:28:46\"},{\"_id\":\"15\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 11:30:47\"},{\"_id\":\"16\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 11:37:43\"},{\"_id\":\"17\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 11:37:43\"},{\"_id\":\"18\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:37:44\"},{\"_id\":\"19\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 11:37:58\"},{\"_id\":\"20\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 11:41:09\"},{\"_id\":\"21\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:41:23\"},{\"_id\":\"22\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:41:24\"},{\"_id\":\"23\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:41:24\"},{\"_id\":\"24\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:41:24\"},{\"_id\":\"25\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:41:58\"},{\"_id\":\"26\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:41:58\"},{\"_id\":\"27\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:45:20\"},{\"_id\":\"28\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:45:20\"},{\"_id\":\"29\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:45:28\"},{\"_id\":\"30\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:45:28\"},{\"_id\":\"31\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:46:02\"},{\"_id\":\"32\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:46:02\"},{\"_id\":\"33\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:46:06\"},{\"_id\":\"34\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:46:07\"},{\"_id\":\"35\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 11:51:18\"},{\"_id\":\"36\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 11:51:18\"},{\"_id\":\"37\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:02:45\"},{\"_id\":\"38\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:02:46\"},{\"_id\":\"39\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:03:41\"},{\"_id\":\"40\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:03:42\"},{\"_id\":\"41\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:03:42\"},{\"_id\":\"42\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:03:42\"},{\"_id\":\"43\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:08:31\"},{\"_id\":\"44\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:08:31\"},{\"_id\":\"45\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:08:34\"},{\"_id\":\"46\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:08:34\"},{\"_id\":\"47\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:11:01\"},{\"_id\":\"48\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:11:01\"},{\"_id\":\"49\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:11:02\"},{\"_id\":\"50\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:11:02\"},{\"_id\":\"51\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:11:02\"},{\"_id\":\"52\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:11:02\"},{\"_id\":\"53\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:11:03\"},{\"_id\":\"54\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:11:03\"},{\"_id\":\"55\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:11:04\"},{\"_id\":\"56\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:11:04\"},{\"_id\":\"57\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:11:05\"},{\"_id\":\"58\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:11:05\"},{\"_id\":\"59\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:11:06\"},{\"_id\":\"60\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:11:06\"},{\"_id\":\"61\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:11:15\"},{\"_id\":\"62\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:11:16\"},{\"_id\":\"63\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:13:08\"},{\"_id\":\"64\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:13:08\"},{\"_id\":\"65\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:13:38\"},{\"_id\":\"66\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:13:38\"},{\"_id\":\"67\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:16:14\"},{\"_id\":\"68\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:16:15\"},{\"_id\":\"69\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:16:15\"},{\"_id\":\"70\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:16:15\"},{\"_id\":\"71\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:16:16\"},{\"_id\":\"72\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:16:16\"},{\"_id\":\"73\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:16:16\"},{\"_id\":\"74\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:16:16\"},{\"_id\":\"75\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:16:17\"},{\"_id\":\"76\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:16:17\"},{\"_id\":\"77\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:08\"},{\"_id\":\"78\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:08\"},{\"_id\":\"79\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:09\"},{\"_id\":\"80\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:09\"},{\"_id\":\"81\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:09\"},{\"_id\":\"82\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:09\"},{\"_id\":\"83\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:10\"},{\"_id\":\"84\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:10\"},{\"_id\":\"85\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:12\"},{\"_id\":\"86\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:13\"},{\"_id\":\"87\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:13\"},{\"_id\":\"88\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:13\"},{\"_id\":\"89\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:15\"},{\"_id\":\"90\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:15\"},{\"_id\":\"91\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:15\"},{\"_id\":\"92\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:17\"},{\"_id\":\"93\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:17\"},{\"_id\":\"94\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:18\"},{\"_id\":\"95\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:18:18\"},{\"_id\":\"96\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:18:19\"},{\"_id\":\"97\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:20:26\"},{\"_id\":\"98\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:20:26\"},{\"_id\":\"99\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:22:59\"},{\"_id\":\"100\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:22:59\"},{\"_id\":\"101\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:24:43\"},{\"_id\":\"102\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:24:43\"},{\"_id\":\"103\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:27:34\"},{\"_id\":\"104\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:27:34\"},{\"_id\":\"105\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:30:49\"},{\"_id\":\"106\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:30:50\"},{\"_id\":\"107\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:30:51\"},{\"_id\":\"108\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:30:51\"},{\"_id\":\"109\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:30:51\"},{\"_id\":\"110\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:30:51\"},{\"_id\":\"111\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:31:02\"},{\"_id\":\"112\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:31:02\"},{\"_id\":\"113\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:31:10\"},{\"_id\":\"114\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:31:10\"},{\"_id\":\"115\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:31:10\"},{\"_id\":\"116\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:31:10\"},{\"_id\":\"117\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:35:56\"},{\"_id\":\"118\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:35:57\"},{\"_id\":\"119\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:38:43\"},{\"_id\":\"120\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:38:43\"},{\"_id\":\"121\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 12:38:43\"},{\"_id\":\"122\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 12:38:54\"},{\"_id\":\"123\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 12:54:57\"},{\"_id\":\"124\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 12:54:57\"},{\"_id\":\"125\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 13:16:22\"},{\"_id\":\"126\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:19:56\"},{\"_id\":\"127\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:22:26\"},{\"_id\":\"128\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:22:26\"},{\"_id\":\"129\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:22:26\"},{\"_id\":\"130\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:22:26\"},{\"_id\":\"131\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:25:08\"},{\"_id\":\"132\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:25:22\"},{\"_id\":\"133\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:26:33\"},{\"_id\":\"134\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:28:22\"},{\"_id\":\"135\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:30:11\"},{\"_id\":\"136\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:30:11\"},{\"_id\":\"137\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:31:46\"},{\"_id\":\"138\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 13:31:46\"},{\"_id\":\"139\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:31:48\"},{\"_id\":\"140\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:31:48\"},{\"_id\":\"141\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:31:50\"},{\"_id\":\"142\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:31:50\"},{\"_id\":\"143\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:31:50\"},{\"_id\":\"144\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:31:51\"},{\"_id\":\"145\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:31:51\"},{\"_id\":\"146\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:31:52\"},{\"_id\":\"147\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:31:52\"},{\"_id\":\"148\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:31:52\"},{\"_id\":\"149\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:31:53\"},{\"_id\":\"150\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:31:53\"},{\"_id\":\"151\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:31:53\"},{\"_id\":\"152\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:31:54\"},{\"_id\":\"153\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 13:55:45\"},{\"_id\":\"154\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 13:55:46\"},{\"_id\":\"155\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 13:55:46\"},{\"_id\":\"156\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 13:55:47\"},{\"_id\":\"157\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 13:57:58\"},{\"_id\":\"158\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 13:58:00\"},{\"_id\":\"159\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 14:02:44\"},{\"_id\":\"160\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 14:02:44\"},{\"_id\":\"161\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 14:03:44\"},{\"_id\":\"162\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 14:03:44\"},{\"_id\":\"163\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 14:08:20\"},{\"_id\":\"164\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 14:08:20\"},{\"_id\":\"165\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 14:26:42\"},{\"_id\":\"166\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 14:26:42\"},{\"_id\":\"167\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 14:28:00\"},{\"_id\":\"168\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 14:28:01\"},{\"_id\":\"169\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 14:28:01\"},{\"_id\":\"170\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 14:28:01\"},{\"_id\":\"171\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 14:29:18\"},{\"_id\":\"172\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 14:29:19\"},{\"_id\":\"173\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 14:52:23\"},{\"_id\":\"174\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 14:52:24\"},{\"_id\":\"175\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 14:59:04\"},{\"_id\":\"176\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 14:59:04\"},{\"_id\":\"177\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 14:59:05\"},{\"_id\":\"178\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 14:59:05\"},{\"_id\":\"179\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 14:59:09\"},{\"_id\":\"180\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 15:05:03\"},{\"_id\":\"181\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 15:05:08\"},{\"_id\":\"182\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:15:29\"},{\"_id\":\"183\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 15:34:04\"},{\"_id\":\"184\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 15:34:04\"},{\"_id\":\"185\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 15:37:49\"},{\"_id\":\"186\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 15:38:55\"},{\"_id\":\"187\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 15:40:00\"},{\"_id\":\"188\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 15:40:00\"},{\"_id\":\"189\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 15:40:00\"},{\"_id\":\"190\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 15:40:01\"},{\"_id\":\"191\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 15:40:01\"},{\"_id\":\"192\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 15:40:02\"},{\"_id\":\"193\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 15:40:02\"},{\"_id\":\"194\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 15:41:22\"},{\"_id\":\"195\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 15:41:31\"},{\"_id\":\"196\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 15:42:53\"},{\"_id\":\"197\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:42:57\"},{\"_id\":\"198\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:42:57\"},{\"_id\":\"199\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:43:18\"},{\"_id\":\"200\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:43:19\"},{\"_id\":\"201\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:49:54\"},{\"_id\":\"202\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:49:54\"},{\"_id\":\"203\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:53:51\"},{\"_id\":\"204\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:53:51\"},{\"_id\":\"205\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:55:29\"},{\"_id\":\"206\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:55:29\"},{\"_id\":\"207\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:55:41\"},{\"_id\":\"208\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:55:41\"},{\"_id\":\"209\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:58:45\"},{\"_id\":\"210\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:58:54\"},{\"_id\":\"211\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:58:54\"},{\"_id\":\"212\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:58:54\"},{\"_id\":\"213\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:58:55\"},{\"_id\":\"214\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:58:55\"},{\"_id\":\"215\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:58:56\"},{\"_id\":\"216\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:58:56\"},{\"_id\":\"217\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:58:57\"},{\"_id\":\"218\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:58:57\"},{\"_id\":\"219\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:58:57\"},{\"_id\":\"220\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:58:57\"},{\"_id\":\"221\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 15:59:08\"},{\"_id\":\"222\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 15:59:08\"},{\"_id\":\"223\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 16:00:00\"},{\"_id\":\"224\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 16:00:00\"},{\"_id\":\"225\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 16:00:45\"},{\"_id\":\"226\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 16:00:45\"},{\"_id\":\"227\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 16:04:42\"},{\"_id\":\"228\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 16:04:42\"},{\"_id\":\"229\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 16:19:24\"},{\"_id\":\"230\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 16:19:24\"},{\"_id\":\"231\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 16:19:27\"},{\"_id\":\"232\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 16:19:27\"},{\"_id\":\"233\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 16:19:34\"},{\"_id\":\"234\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 16:19:34\"},{\"_id\":\"235\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 16:22:34\"},{\"_id\":\"236\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 16:22:34\"},{\"_id\":\"237\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 16:30:39\"},{\"_id\":\"238\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 16:30:39\"},{\"_id\":\"239\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 16:41:35\"},{\"_id\":\"240\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 16:41:36\"},{\"_id\":\"241\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 17:06:35\"},{\"_id\":\"242\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 17:06:35\"},{\"_id\":\"243\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 17:06:36\"},{\"_id\":\"244\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 17:06:36\"},{\"_id\":\"245\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 17:07:48\"},{\"_id\":\"246\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 17:07:48\"},{\"_id\":\"247\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 17:07:48\"},{\"_id\":\"248\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 17:07:48\"},{\"_id\":\"249\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 17:08:51\"},{\"_id\":\"250\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 17:08:51\"},{\"_id\":\"251\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 17:28:04\"},{\"_id\":\"252\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 17:28:05\"},{\"_id\":\"253\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 19:38:49\"},{\"_id\":\"254\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 19:38:50\"},{\"_id\":\"255\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 19:50:41\"},{\"_id\":\"256\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 19:50:41\"},{\"_id\":\"257\",\"kind\":\"NIU_POCKET\",\"day\":\"2017 janv. 30 19:57:23\"},{\"_id\":\"258\",\"kind\":\"NIU\",\"day\":\"2017 janv. 30 19:57:23\"},{\"_id\":\"259\",\"kind\":\"IU_CALLING\",\"day\":\"2017 janv. 30 20:04:48\"},{\"_id\":\"260\",\"kind\":\"IU\",\"day\":\"2017 janv. 30 20:04:49\"}]}\n";
        try{
            myWeberver.parseAndStoreJSON(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
        try {
            MyWeberver myWeberver = new MyWeberver();
            ServerSocket ss = new ServerSocket(myWeberver.port);
            for (;;) {
                // Wait for a client to connect. The method will block;
                // when it returns the socket will be connected to the client
                Socket client = ss.accept();
                System.out.println("New client");

                // Get input and output streams to talk to the client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream());

                String result="";
                while((result = in.readLine()) != null){
                    System.out.println("Data : " + result);
                    try{
                        myWeberver.parseAndStoreJSON(result);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                //TODO out
                out.close(); // Flush and close the output stream
                in.close(); // Close the input stream
                client.close(); // Close the socket itself
            }
        }
        catch (Exception e) {
            System.err.println(e);
            System.err.println("Usage: java HttpMirror <port>");
        }
    }
}

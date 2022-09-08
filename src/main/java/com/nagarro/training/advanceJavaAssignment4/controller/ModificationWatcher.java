package com.nagarro.training.advanceJavaAssignment4.controller;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import com.nagarro.training.advanceJavaAssignment4.dao.TshirtDao;

public class ModificationWatcher {

	public static void modificationTrack() {
		// TODO Auto-generated method stub

		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path path = Paths.get("C:\\Users\\sujaypaul\\Desktop\\Assignments\\sujay-paul\\Advanced-Java-Assignment-4\\CSV");
			keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY), path);

			WatchKey watchKey;
			do {
				watchKey = service.take();

				if (watchKey.pollEvents().get(0) != null) {
					System.out.println("database updated ..........");
//					TshirtDao.truncateTshirt();
					TshirtCsvFileReader.getAllTshirts();
				}

			} while (watchKey.reset());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

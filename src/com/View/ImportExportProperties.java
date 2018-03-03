/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

/**
 *
 * @author Ajinkya
 */
import java.awt.Component;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ImportExportProperties {

	private static JFileChooser chooser = new JFileChooser();;

	public static TextEditorBox load() {

		int r = chooser.showOpenDialog(null);
		TextEditorBox jp = null;

		// if file selected, open
		if (r == JFileChooser.APPROVE_OPTION) {
			FileInputStream in = null;
			try {
				File file = chooser.getSelectedFile();
				in = new FileInputStream(file);
				XMLDecoder decoder = new XMLDecoder(in);
				jp = (TextEditorBox) decoder.readObject();
				decoder.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		return jp;
	}

	public static void save(TextEditorBox comps) {

		chooser.setCurrentDirectory(new File("."));
		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			FileOutputStream out = null;
			try {
				File file = chooser.getSelectedFile();
				File newFile = new File(file.getName()+".if");
				file.renameTo(newFile);
				out = new FileOutputStream(file);
				XMLEncoder encoder = new XMLEncoder(out);
				System.out.println("save >>>>>"+comps.toString());
				encoder.writeObject(comps);
				encoder.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}

	}

}
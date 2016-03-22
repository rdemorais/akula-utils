package br.com.akula.api.file;

import java.io.IOException;

import org.springframework.core.io.Resource;

public interface AkulaFileSystem {
	public String getResourceContent(String location) throws IOException;
	public Resource getResource(String location);
	public Resource[] getResources(String location) throws IOException;
}
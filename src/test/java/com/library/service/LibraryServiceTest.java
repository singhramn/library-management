package com.library.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.library.dao.repositories.LibraryRepository;
import com.library.entity.Library;
import com.library.service.impl.LibraryServiceImpl;

public class LibraryServiceTest {

	public static final String LIBRARY_NAME = "ABC LIBRARY";
	public static final long LIBRARY_ID = 1;
	public static final String ADDRESS = "Noida";
	public static final String PHONE_NUMBER = "9811111";

	@InjectMocks
	private LibraryServiceImpl LibraryService;

	@Mock
	private LibraryRepository LibraryRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		List<Library> Librarys = new ArrayList<>();
		Librarys.add(getLibraryEntity());
		when(LibraryRepository.getOne(LIBRARY_ID)).thenReturn(getLibraryEntity());
		when(LibraryService.addLibrary(getLibraryEntity())).thenReturn(getLibraryEntity());
		when(LibraryService.updateLibraryDetails(getLibraryEntity())).thenReturn(getLibraryEntity());
		when(LibraryService.listLibraries()).thenReturn(Librarys);
	}

	@Test
	public void addLibraryTest() {
		Library LibraryResult = LibraryService.addLibrary(getLibraryEntity());
		Assert.assertEquals(LIBRARY_ID, LibraryResult.getLibId());
		Assert.assertEquals(LIBRARY_NAME, LibraryResult.getLibName());
		Assert.assertEquals(ADDRESS, LibraryResult.getAddress());
		Assert.assertEquals(PHONE_NUMBER, LibraryResult.getPhoneNumber());
	}

	@Test
	public void updateLibraryTest() {

		Library LibraryResult = LibraryService.updateLibraryDetails(getLibraryEntity());
		Assert.assertEquals(LIBRARY_ID, LibraryResult.getLibId());
		Assert.assertEquals(LIBRARY_NAME, LibraryResult.getLibName());
		Assert.assertEquals(ADDRESS, LibraryResult.getAddress());
		Assert.assertEquals(PHONE_NUMBER, LibraryResult.getPhoneNumber());
	}

	@Test
	public void listLibrarysTest() {
		List<Library> LibrarysActual = LibraryService.listLibraries();
		Assert.assertEquals(1, LibrarysActual.size());
		Assert.assertEquals(LIBRARY_ID, LibrarysActual.get(0).getLibId());
		Assert.assertEquals(LIBRARY_NAME, LibrarysActual.get(0).getLibName());
		Assert.assertEquals(ADDRESS, LibrarysActual.get(0).getAddress());
		Assert.assertEquals(PHONE_NUMBER, LibrarysActual.get(0).getPhoneNumber());
	}

	@Test
	public void deleteLibraryTest() {
		boolean deleteResult = LibraryService.deleteLibraryById(LIBRARY_ID);
		Assert.assertTrue(deleteResult);
	}

	public Library getLibraryEntity() {
		Library Library = new Library();
		Library.setLibId(LIBRARY_ID);
		Library.setAddress(ADDRESS);
		Library.setLibName(LIBRARY_NAME);
		Library.setPhoneNumber(PHONE_NUMBER);
		return Library;
	}
}
